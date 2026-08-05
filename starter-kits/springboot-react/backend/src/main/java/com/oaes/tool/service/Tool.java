package com.oaes.tool.service;

import com.oaes.tool.dto.ToolRequest;
import com.oaes.tool.dto.ToolResponse;
import com.oaes.tool.enums.ToolType;

public interface Tool {

    ToolType getType();

    ToolResponse execute(ToolRequest request);

}