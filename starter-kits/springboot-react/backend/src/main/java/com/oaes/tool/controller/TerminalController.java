package com.oaes.tool.controller;

import com.oaes.tool.dto.ToolRequest;
import com.oaes.tool.dto.ToolResponse;
import com.oaes.tool.tools.TerminalTool;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/terminal")
@RequiredArgsConstructor
public class TerminalController {

    private final TerminalTool terminalTool;

    @PostMapping("/execute")
    public ToolResponse execute(
            @RequestBody ToolRequest request
    ) {

        return terminalTool.execute(request);

    }

}