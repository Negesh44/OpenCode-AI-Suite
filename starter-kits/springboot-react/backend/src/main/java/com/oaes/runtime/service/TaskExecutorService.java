package com.oaes.runtime.service;

import com.oaes.planner.model.PlannerTask;
import com.oaes.tool.dto.ToolRequest;
import com.oaes.tool.dto.ToolResponse;
import com.oaes.tool.executor.ToolExecutor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskExecutorService {

    private final ToolExecutor toolExecutor;

    public ToolResponse execute(
            UUID workspaceId,
            PlannerTask task
    ) {

        ToolRequest request =
                ToolRequest.builder()
                        .tool(task.getTool())
                        .action(task.getAction())
                        .workspaceId(workspaceId)
                        .path(task.getPath())
                        .content(task.getContent())
                        .command(task.getCommand())
                        .build();

        return toolExecutor.execute(request);

    }

}