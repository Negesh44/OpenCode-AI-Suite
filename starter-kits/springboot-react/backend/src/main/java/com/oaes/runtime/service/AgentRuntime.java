package com.oaes.runtime.service;

import com.oaes.planner.dto.PlannerRequest;
import com.oaes.planner.model.PlannerResult;
import com.oaes.planner.model.PlannerTask;
import com.oaes.planner.service.AIPlannerService;
import com.oaes.planner.service.PlannerService;
import com.oaes.runtime.dto.AgentRequest;
import com.oaes.runtime.dto.AgentResponse;
import com.oaes.tool.dto.ToolResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgentRuntime {

    private final AIPlannerService aiPlannerService;
    private final PlannerService plannerService;
    private final TaskExecutorService taskExecutorService;

    public AgentResponse run(AgentRequest request) {

        PlannerResult plan;

        try {

            plan = aiPlannerService.createPlan(
                    request.getGoal()
            );

        } catch (Exception e) {

            PlannerRequest plannerRequest = new PlannerRequest();
            plannerRequest.setGoal(request.getGoal());

            plan = plannerService.createPlan(
                    plannerRequest
            );

        }

        StringBuilder output = new StringBuilder();

        for (PlannerTask task : plan.getTasks()) {

            System.out.println("--------------------------------");
            System.out.println("Executing Step : " + task.getStep());
            System.out.println("Description    : " + task.getDescription());
            System.out.println("Tool           : " + task.getTool());
            System.out.println("Action         : " + task.getAction());
            System.out.println("Path           : " + task.getPath());
            System.out.println("--------------------------------");

            ToolResponse response =
                    taskExecutorService.execute(
                            request.getWorkspaceId(),
                            task
                    );

            output.append(task.getStep())
                    .append(". ")
                    .append(response.getMessage())
                    .append("\n");

        }

        return AgentResponse.builder()
                .result(output.toString())
                .build();

    }

}