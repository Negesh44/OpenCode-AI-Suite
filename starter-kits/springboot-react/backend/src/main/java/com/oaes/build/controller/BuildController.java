package com.oaes.build.controller;

import com.oaes.build.dto.BuildResult;
import com.oaes.build.service.BuildService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/build")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class BuildController {

    private final BuildService buildService;

    @PostMapping("/maven")
    public ResponseEntity<BuildResult> build(
            @RequestParam UUID workspaceId
    ) throws Exception {

        return ResponseEntity.ok(
                buildService.mavenBuild(workspaceId)
        );

    }

}