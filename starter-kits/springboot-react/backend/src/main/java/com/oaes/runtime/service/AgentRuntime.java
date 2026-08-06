package com.oaes.runtime.service;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.stereotype.Service;
import com.oaes.context.model.ProjectContext;
import com.oaes.build.dto.BuildResult;
import com.oaes.build.service.BuildRepairService;
import com.oaes.coder.service.CodeGenerationService;
import com.oaes.memory.model.ProjectFile;
import com.oaes.memory.service.ProjectMemoryService;
import com.oaes.memory.service.ProjectRetrieverService;
import com.oaes.context.service.ProjectContextService;
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
import com.oaes.reviewer.service.ReviewService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AgentRuntime {

    private final AIPlannerService aiPlannerService;
    private final PlannerService plannerService;
    private final TaskExecutorService taskExecutorService;
    private final CodeGenerationService codeGenerationService;
    private final ReviewService reviewService;
    private final CodeEditorService codeEditorService;
    private final ProjectContextService projectContextService;
    private final WorkspaceStorageService workspaceStorageService;
    private final GitAutomationService gitAutomationService;
    private final BuildRepairService buildRepairService;
    private final AgentProgressService progressService;
    private final ProjectMemoryService projectMemoryService;
    private final ProjectRetrieverService projectRetrieverService;

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
        progressService.publish(
        "CONTEXT",
        "Scanning workspace...",
        25
);

ProjectContext context;

try {

    context = projectContextService.build(
            request.getWorkspaceId()
    );

    progressService.publish(
            "CONTEXT",
            "Workspace scanned.",
            30
    );

} catch (Exception e) {

    e.printStackTrace();

    context = ProjectContext.builder().build();

    progressService.publish(
            "CONTEXT",
            "Workspace scan failed.",
            30
    );
}

progressService.publish(
        "MEMORY",
        "Finding relevant project files...",
        35
);

List<String> relevantFiles =
        projectRetrieverService.retrieve(
                context.getFiles(),
                request.getGoal()
        );
      

progressService.publish(
        "MEMORY",
        relevantFiles.size() + " files selected.",
        38
);



progressService.publish(
        "MEMORY",
        "Loading project files...",
        40
);

List<ProjectFile> memory;

try {

    memory = projectMemoryService.load(
            request.getWorkspaceId()
    );

} catch (Exception e) {

    memory = List.of();

}

progressService.publish(
        "MEMORY",
        "Project memory ready.",
        45
);
List<ProjectFile> relevantMemory =
        memory.stream()
                .filter(file ->
                        relevantFiles.contains(file.getPath()))
                .toList();
        StringBuilder output = new StringBuilder();

        output.append("========== EXECUTING PLAN ==========\n");

        for (PlannerTask task : plan.getTasks()) {

           String target = task.getPath();

if (target == null || target.isBlank()) {
    target = task.getCommand();
}

progressService.publish(
        "TASK",
        "Executing " + target,
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
        task.getDescription(),
        context,
        relevantFiles,
        relevantMemory
);   
if (generatedCode != null &&
        !generatedCode.isBlank()) {

    progressService.publish(
            "REVIEW",
            "Reviewing " + task.getPath(),
            45
    );
generatedCode =
       reviewService.review(
        task.getPath(),
        generatedCode,
        context,
        relevantFiles,
        relevantMemory
);

    progressService.publish(
            "REVIEW",
            "Review completed.",
            48
    );

} else {

    generatedCode = "";

}

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

if (updatedCode != null &&
        !updatedCode.isBlank()) {

    progressService.publish(
            "REVIEW",
            "Reviewing updated file " + task.getPath(),
            50
    );

updatedCode =
       reviewService.review(
        task.getPath(),
        updatedCode,
        context,
        relevantFiles,
        relevantMemory
);
    progressService.publish(
            "REVIEW",
            "Review completed.",
            55
    );

} else {

    updatedCode = currentCode;

}

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
                        progressService.publish(
        "TASK",
        "Completed " + task.getStep(),
        60
);

            } catch (Exception ex) {


                ex.printStackTrace();
                progressService.publish(
        "ERROR",
        ex.getMessage(),
        60
);

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
                progressService.publish(
        "GIT",
        "Git Commit Completed",
        98
);
progressService.publish(
        "DONE",
        "Project Completed",
        100
);

            } catch (Exception e) {
                e.printStackTrace();
    progressService.publish(
            "GIT",
            "Git Commit Failed",
            98
    );

    progressService.publish(
            "DONE",
            "Completed (Git Commit Failed)",
            100
    );

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
            progressService.publish(
        "DONE",
        "Execution Finished With Errors",
        100
);
            output.append("❌ BUILD FAILED\n");
            output.append(buildResult.getErrors());
        }

        

        output.append("\n========== FINISHED ==========\n");

        return AgentResponse.builder()
                .result(output.toString())
                .build();
    }
}