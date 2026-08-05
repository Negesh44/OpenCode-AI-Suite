package com.oaes.planner.model;

import com.oaes.tool.enums.ToolType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlannerTask {

    private int step;

    private String description;

    private ToolType tool;

    private String action;

    private String path;

    private String content;

}