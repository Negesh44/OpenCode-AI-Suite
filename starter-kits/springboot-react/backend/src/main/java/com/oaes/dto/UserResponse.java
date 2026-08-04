package com.oaes.dto;

import com.oaes.entity.Role;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private UUID id;

    private String fullName;

    private String email;

    private Role role;

    private boolean active;
}