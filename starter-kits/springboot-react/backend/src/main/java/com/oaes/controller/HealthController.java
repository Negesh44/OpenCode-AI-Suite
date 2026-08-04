package com.oaes.controller;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oaes.dto.response.ApiResponse;

@RestController
@RequestMapping("/api")
public class HealthController {

    @GetMapping("/health")
    public ApiResponse<Map<String,Object>> health(){

        return new ApiResponse<>(
                true,
                "Application Running",
                Map.of(
                        "status","UP",
                        "time", LocalDateTime.now()
                )
        );
    }

}