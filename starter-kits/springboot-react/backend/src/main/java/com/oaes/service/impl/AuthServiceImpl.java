package com.oaes.service.impl;

import com.oaes.dto.request.LoginRequest;
import com.oaes.dto.request.RegisterRequest;
import com.oaes.dto.response.ApiResponse;
import com.oaes.dto.response.AuthResponse;
import com.oaes.entity.Role;
import com.oaes.entity.User;
import com.oaes.repository.UserRepository;
import com.oaes.security.JwtService;
import com.oaes.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public ApiResponse<?> register(RegisterRequest request) {

        if (repository.existsByEmail(request.getEmail())) {
            return new ApiResponse<>(
                    false,
                    "Email already exists",
                    null
            );
        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        repository.save(user);

        return new ApiResponse<>(
                true,
                "User registered successfully",
                null
        );
    }

    @Override
    public ApiResponse<?> login(LoginRequest request) {

        User user = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtService.generateToken(user.getEmail());

        AuthResponse response = new AuthResponse(
                token,
                user.getEmail(),
                user.getRole().name()
        );

        return new ApiResponse<>(
                true,
                "Login successful",
                response
        );
    }

}