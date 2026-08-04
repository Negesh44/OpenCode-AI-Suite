package com.oaes.controller;

import com.oaes.dto.response.ApiResponse;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/me")
    public ApiResponse<?> me(Authentication authentication){

        return new ApiResponse<>(
                true,
                "Authenticated User",
                authentication.getName()
        );

    }

}