package com.oaes.service.impl;

import com.oaes.entity.RefreshToken;
import com.oaes.entity.User;
import com.oaes.repository.RefreshTokenRepository;
import com.oaes.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService {

    private final RefreshTokenRepository repository;

    @Override
    public RefreshToken create(User user) {

        RefreshToken token = RefreshToken.builder()
                .token(UUID.randomUUID().toString())
                .user(user)
                .expiryDate(LocalDateTime.now().plusDays(7))
                .build();

        return repository.save(token);

    }

    @Override
    public boolean validate(String token) {

        return repository.findByToken(token)
                .filter(t -> t.getExpiryDate().isAfter(LocalDateTime.now()))
                .isPresent();

    }

    @Override
    public void delete(User user) {

        repository.findAll()
                .stream()
                .filter(t -> t.getUser().getId().equals(user.getId()))
                .forEach(repository::delete);

    }

}