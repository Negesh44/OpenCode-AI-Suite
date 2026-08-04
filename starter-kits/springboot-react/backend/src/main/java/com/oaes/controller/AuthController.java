package com.oaes.controller;

import com.oaes.dto.request.LoginRequest;
import com.oaes.dto.request.RegisterRequest;
import com.oaes.dto.response.ApiResponse;
import com.oaes.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ApiResponse<?> register(
            @Valid @RequestBody RegisterRequest request) {

        return authService.register(request);
    }

    @PostMapping("/login")
    public ApiResponse<?> login(
            @Valid @RequestBody LoginRequest request) {

        return authService.login(request);
    }

}