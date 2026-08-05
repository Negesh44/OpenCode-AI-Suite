package com.oaes.tool.registry;

import com.oaes.tool.enums.ToolType;
import com.oaes.tool.service.Tool;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Component
public class ToolRegistry {

    private final Map<ToolType, Tool> tools = new EnumMap<>(ToolType.class);

    public ToolRegistry(List<Tool> toolList) {

        for (Tool tool : toolList) {
            tools.put(tool.getType(), tool);
        }

    }

    public Tool getTool(ToolType type) {
        return tools.get(type);
    }

}