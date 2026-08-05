package com.oaes.runtime.service;

import com.oaes.build.dto.BuildResult;
import com.oaes.build.service.BuildRepairService;
import com.oaes.coder.service.CodeGenerationService;
import com.oaes.editor.dto.EditRequest;
import com.oaes.editor.service.CodeEditorService;
import com.oaes.git.service.GitAutomationService;
import com.oaes.planner.dto.PlannerRequest;
import com.oaes.planner.model.PlannerResult;
import com.oaes.planner.model.PlannerTask;
import com.oaes.planner.service.AIPlannerService;
import com.oaes.planner.service.PlannerService;
import com.oaes.runtime.dto.AgentRequest;
import com.oaes.runtime.dto.AgentResponse;
import com.oaes.storage.service.WorkspaceStorageService;
import com.oaes.tool.dto.ToolResponse;
import com.oaes.tool.enums.ToolType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;

@Service
@RequiredArgsConstructor
public class AgentRuntime {

    private final AIPlannerService aiPlannerService;
    private final PlannerService plannerService;
    private final TaskExecutorService taskExecutorService;
    private final CodeGenerationService codeGenerationService;
    private final CodeEditorService codeEditorService;
    private final WorkspaceStorageService workspaceStorageService;
    private final GitAutomationService gitAutomationService;
    private final BuildRepairService buildRepairService;
    private final AgentProgressService progressService;

    public AgentResponse run(AgentRequest request) {

        PlannerResult plan;

        progressService.publish(
                "PLANNER",
                "Creating execution plan...",
                10
        );

        try {

            plan = aiPlannerService.createPlan(request.getGoal());

            progressService.publish(
                    "PLANNER",
                    "Execution plan created.",
                    20
            );

        } catch (Exception e) {

            progressService.publish(
                    "PLANNER",
                    "AI planner failed. Using default planner...",
                    15
            );

            PlannerRequest plannerRequest = new PlannerRequest();
            plannerRequest.setGoal(request.getGoal());

            plan = plannerService.createPlan(plannerRequest);

            progressService.publish(
                    "PLANNER",
                    "Default plan created.",
                    20
            );
        }

        StringBuilder output = new StringBuilder();

        output.append("========== EXECUTING PLAN ==========\n");

        for (PlannerTask task : plan.getTasks()) {

            progressService.publish(
                    "TASK",
                    "Executing " + task.getPath(),
                    40
            );

            try {

                if (task.getTool() == ToolType.FILE &&
                        "CREATE".equalsIgnoreCase(task.getAction())) {

                    if (task.getContent() == null ||
                            task.getContent().isBlank()) {

                        String generatedCode =
                                codeGenerationService.generate(
                                        task.getPath(),
                                        task.getDescription()
                                );

                        task.setContent(generatedCode);
                    }
                }

                if (task.getTool() == ToolType.FILE &&
                        "UPDATE".equalsIgnoreCase(task.getAction())) {

                    Path file =
                            workspaceStorageService.resolvePath(
                                    request.getWorkspaceId(),
                                    task.getPath()
                            );

                    String currentCode = "";

                    if (Files.exists(file)) {
                        currentCode = Files.readString(file);
                    }

                    EditRequest editRequest =
                            EditRequest.builder()
                                    .fileName(task.getPath())
                                    .currentCode(currentCode)
                                    .instruction(task.getInstruction())
                                    .build();

                    String updatedCode =
                            codeEditorService.edit(editRequest);

                    task.setContent(updatedCode);
                }

                ToolResponse response =
                        taskExecutorService.execute(
                                request.getWorkspaceId(),
                                task
                        );

                output.append(task.getStep())
                        .append(". ")
                        .append(response.getMessage())
                        .append("\n");

            } catch (Exception ex) {

                ex.printStackTrace();

                output.append(task.getStep())
                        .append(". ERROR : ")
                        .append(ex.getMessage())
                        .append("\n");
            }
        }

        progressService.publish(
                "BUILD",
                "Running Maven Build...",
                70
        );

        output.append("\n========== BUILD ==========\n");

        BuildResult buildResult =
                buildRepairService.repair(request);

        if (buildResult.isSuccess()) {

            progressService.publish(
                    "BUILD",
                    "Build Successful",
                    90
            );

            output.append("✅ BUILD SUCCESS\n");

            try {

                progressService.publish(
                        "GIT",
                        "Creating Git Commit...",
                        95
                );

                gitAutomationService.autoCommit(
                        request.getWorkspaceId(),
                        request.getGoal()
                );

                output.append("✅ Git commit completed.\n");

            } catch (Exception e) {

                output.append("⚠ Git commit failed : ")
                        .append(e.getMessage())
                        .append("\n");
            }

        } else {

            progressService.publish(
                    "BUILD",
                    "Build Failed",
                    90
            );

            output.append("❌ BUILD FAILED\n");
            output.append(buildResult.getErrors());
        }

        progressService.publish(
                "DONE",
                "Project Completed",
                100
        );

        output.append("\n========== FINISHED ==========\n");

        return AgentResponse.builder()
                .result(output.toString())
                .build();
    }
}