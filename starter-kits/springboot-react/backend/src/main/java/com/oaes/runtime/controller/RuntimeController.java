package com.oaes.runtime.controller;

import com.oaes.runtime.dto.AgentRequest;
import com.oaes.runtime.dto.AgentResponse;
import com.oaes.runtime.service.AgentRuntime;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/runtime")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RuntimeController {

    private final AgentRuntime runtime;

   @PostMapping("/chat")
public ResponseEntity<AgentResponse> chat(
        @RequestBody AgentRequest request) {

    return ResponseEntity.ok(
            runtime.run(request)
    );
}
}