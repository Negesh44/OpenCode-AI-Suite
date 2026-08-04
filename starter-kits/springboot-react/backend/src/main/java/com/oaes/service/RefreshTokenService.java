package com.oaes.service;

import com.oaes.entity.RefreshToken;
import com.oaes.entity.User;

public interface RefreshTokenService {

    RefreshToken create(User user);

    boolean validate(String token);

    void delete(User user);

}