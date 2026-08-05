package com.oaes.tool.dto;

import com.oaes.tool.enums.ToolType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToolRequest {

    private ToolType tool;

    private String action;

    private String input;

}