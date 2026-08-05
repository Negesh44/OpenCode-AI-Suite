package com.oaes.tool.controller;

import com.oaes.tool.dto.ToolRequest;
import com.oaes.tool.dto.ToolResponse;
import com.oaes.tool.executor.ToolExecutor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tools")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ToolController {

    private final ToolExecutor toolExecutor;

    @PostMapping("/execute")
    public ResponseEntity<ToolResponse> execute(
            @RequestBody ToolRequest request
    ) {

        return ResponseEntity.ok(
                toolExecutor.execute(request)
        );

    }
}