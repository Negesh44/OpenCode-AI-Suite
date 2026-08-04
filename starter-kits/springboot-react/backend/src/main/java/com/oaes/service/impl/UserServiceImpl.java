package com.oaes.service.impl;

import com.oaes.dto.response.UserResponse;
import com.oaes.entity.User;
import com.oaes.mapper.UserMapper;
import com.oaes.repository.UserRepository;
import com.oaes.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public List<UserResponse> findAll() {

        return repository.findAll()
                .stream()
                .map(UserMapper::toResponse)
                .toList();

    }

    @Override
    public UserResponse findById(Long id) {

        User user = repository.findById(id)
                .orElseThrow();

        return UserMapper.toResponse(user);

    }

}