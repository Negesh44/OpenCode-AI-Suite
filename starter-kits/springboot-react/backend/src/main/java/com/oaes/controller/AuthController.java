package com.oaes.controller;

import com.oaes.dto.AuthResponse;
import com.oaes.dto.LoginRequest;
import com.oaes.dto.RegisterRequest;
import com.oaes.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public AuthResponse register(
            @Valid @RequestBody RegisterRequest request) {

        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(
            @Valid @RequestBody LoginRequest request) {

        return authService.login(request);
    }

    @GetMapping("/me")
    public String currentUser(Authentication authentication) {

        return authentication.getName();
    }
}