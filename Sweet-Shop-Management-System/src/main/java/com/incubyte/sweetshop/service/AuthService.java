package com.incubyte.sweetshop.service;

import com.incubyte.sweetshop.config.JwtUtil;
import com.incubyte.sweetshop.dto.AuthRequest;
import com.incubyte.sweetshop.dto.AuthResponse;
import com.incubyte.sweetshop.entity.User;
import com.incubyte.sweetshop.repository.UserRepository;
import com.incubyte.sweetshop.dto.RegisterRequest;
import com.incubyte.sweetshop.entity.User;


public class AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    public AuthResponse loginAndGenerateToken(AuthRequest request) {
        User user = userRepository.findByUsername(request.getUsername());

        if (user == null || !user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user);
        return new AuthResponse(token);
    }
    public User register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("User already exists");
        }

        User user = new User(
                request.getUsername(),
                request.getPassword()
        );

        return userRepository.save(user);
    }
}
