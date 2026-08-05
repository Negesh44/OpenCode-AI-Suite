package com.oaes.tool.executor;

import com.oaes.tool.dto.ToolRequest;
import com.oaes.tool.dto.ToolResponse;
import com.oaes.tool.registry.ToolRegistry;
import com.oaes.tool.service.Tool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ToolExecutor {

    private final ToolRegistry toolRegistry;

    public ToolResponse execute(ToolRequest request) {

        Tool tool = toolRegistry.getTool(request.getTool());

        if (tool == null) {
            return ToolResponse.builder()
                    .success(false)
                    .message("Tool not found: " + request.getTool())
                    .build();
        }

        return tool.execute(request);
    }
}