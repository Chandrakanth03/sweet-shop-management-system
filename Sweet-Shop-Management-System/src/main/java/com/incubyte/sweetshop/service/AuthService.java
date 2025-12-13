package com.incubyte.sweetshop.service;

import com.incubyte.sweetshop.config.JwtUtil;
import com.incubyte.sweetshop.dto.AuthRequest;
import com.incubyte.sweetshop.dto.RegisterRequest;
import com.incubyte.sweetshop.entity.User;
import com.incubyte.sweetshop.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    // ✅ REGISTER METHOD
    public void register(RegisterRequest request) {

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("User already exists");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword()); // (plain for now)

        userRepository.save(user);
    }

    // ✅ LOGIN METHOD (THIS WAS MISSING)
    public String login(AuthRequest request) {

        User user = userRepository.findByUsername(request.getUsername());

        if (user == null) {
            throw new RuntimeException("Invalid username or password");
        }

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        return jwtUtil.generateToken(user.getUsername());
    }
}
