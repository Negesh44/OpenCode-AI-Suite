package com.oaes.run.controller;

import com.oaes.run.dto.RunResult;
import com.oaes.run.service.RunService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/run")
@RequiredArgsConstructor
public class RunController {

    private final RunService runService;

    @PostMapping
    public RunResult run(
            @RequestParam UUID workspaceId
    ) {

        return runService.runSpringBoot(workspaceId);

    }

}