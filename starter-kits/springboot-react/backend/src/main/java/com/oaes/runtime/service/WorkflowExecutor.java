package com.oaes.runtime.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.oaes.planner.model.PlannerResult;
import com.oaes.planner.model.PlannerTask;
import com.oaes.tool.dto.ToolResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WorkflowExecutor {

    private final TaskExecutorService taskExecutorService;
    private final AgentProgressService progressService;

    public String execute(
            UUID workspaceId,
            PlannerResult plan
    ) {

        StringBuilder output = new StringBuilder();

        output.append("========== EXECUTING PLAN ==========\n");

        int total = plan.getTasks().size();
        int completed = 0;

        for (PlannerTask task : plan.getTasks()) {

            completed++;

            int percent =
                    20 + (completed * 50 / Math.max(total, 1));

            progressService.publish(
                    "TASK",
                    "Executing " + task.getDescription(),
                    percent
            );

            try {

                ToolResponse response =
                        taskExecutorService.execute(
                                workspaceId,
                                task
                        );

                output.append(task.getStep())
                        .append(". ")
                        .append(response.getMessage())
                        .append("\n");

            } catch (Exception e) {

                output.append(task.getStep())
                        .append(". ERROR : ")
                        .append(e.getMessage())
                        .append("\n");

            }

        }

        return output.toString();

    }

}