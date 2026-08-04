package com.oaes.mapper;

import com.oaes.dto.response.UserResponse;
import com.oaes.entity.User;

public class UserMapper {

    public static UserResponse toResponse(User user){

        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole().name())
                .build();

    }

}