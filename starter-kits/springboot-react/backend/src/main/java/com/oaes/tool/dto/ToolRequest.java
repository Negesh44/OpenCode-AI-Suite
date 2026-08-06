package com.oaes.tool.dto;

import com.oaes.tool.enums.ToolType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToolRequest {

    private ToolType tool;

    private String action;

    private UUID workspaceId;

    private String path;

    private String content;

    private String command;

    private Map<String, Object> parameters;

}