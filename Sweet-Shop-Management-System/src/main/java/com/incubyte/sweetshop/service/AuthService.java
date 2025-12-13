package com.incubyte.sweetshop.service;

import com.incubyte.sweetshop.dto.RegisterRequest;
import com.incubyte.sweetshop.entity.User;
import com.incubyte.sweetshop.exception.UserAlreadyExistsException;
import com.incubyte.sweetshop.repository.UserRepository;

public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(RegisterRequest request) {

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new UserAlreadyExistsException("User already exists");
        }

        User user = new User(request.getUsername(), request.getPassword());

        return userRepository.save(user);
    }

}

