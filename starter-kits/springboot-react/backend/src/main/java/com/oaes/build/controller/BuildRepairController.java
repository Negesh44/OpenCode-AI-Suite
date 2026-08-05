package com.oaes.build.controller;

import com.oaes.build.dto.BuildResult;
import com.oaes.build.service.BuildRepairService;
import com.oaes.runtime.dto.AgentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/build")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class BuildRepairController {

    private final BuildRepairService buildRepairService;

    @PostMapping("/repair")
    public ResponseEntity<BuildResult> repair(
            @RequestBody AgentRequest request
    ) {

        return ResponseEntity.ok(
                buildRepairService.repair(request)
        );

    }

}