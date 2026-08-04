package com.oaes.service;

import com.oaes.dto.request.LoginRequest;
import com.oaes.dto.request.RegisterRequest;
import com.oaes.dto.response.ApiResponse;

public interface AuthService {

    ApiResponse<?> register(RegisterRequest request);

    ApiResponse<?> login(LoginRequest request);

}