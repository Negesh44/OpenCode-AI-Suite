package com.oaes.tool.tools;

import com.oaes.tool.dto.ToolRequest;
import com.oaes.tool.dto.ToolResponse;
import com.oaes.tool.enums.ToolType;
import com.oaes.tool.service.Tool;
import org.springframework.stereotype.Component;

@Component
public class FileTool implements Tool {

    @Override
    public ToolType getType() {
        return ToolType.FILE;
    }

    @Override
    public ToolResponse execute(ToolRequest request) {

        return ToolResponse.builder()
                .success(true)
                .result("File Tool Ready")
                .build();

    }
}