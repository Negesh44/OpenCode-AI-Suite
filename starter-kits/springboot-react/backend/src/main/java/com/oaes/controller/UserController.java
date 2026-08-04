package com.oaes.controller;

import com.oaes.dto.response.ApiResponse;
import com.oaes.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<?> findAll(){

        return new ApiResponse<>(
                true,
                "Users",
                service.findAll()
        );

    }

    @GetMapping("/{id}")
    public ApiResponse<?> findById(@PathVariable Long id){

        return new ApiResponse<>(
                true,
                "User",
                service.findById(id)
        );

    }

}