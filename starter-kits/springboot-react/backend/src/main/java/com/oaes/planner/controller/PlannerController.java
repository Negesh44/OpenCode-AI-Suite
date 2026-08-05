package com.oaes.planner.controller;

import com.oaes.planner.dto.PlannerRequest;
import com.oaes.planner.dto.PlannerResponse;
import com.oaes.planner.service.PlannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/planner")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PlannerController {

    private final PlannerService plannerService;

    @PostMapping
    public ResponseEntity<PlannerResponse> createPlan(
            @RequestBody PlannerRequest request) {

        return ResponseEntity.ok(
                PlannerResponse.builder()
                        .plan(plannerService.createPlan(request))
                        .build()
        );
    }
}