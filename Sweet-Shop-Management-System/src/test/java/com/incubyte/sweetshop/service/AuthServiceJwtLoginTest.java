package com.incubyte.sweetshop.service;

import com.incubyte.sweetshop.config.JwtUtil;
import com.incubyte.sweetshop.dto.AuthRequest;
import com.incubyte.sweetshop.dto.AuthResponse;
import com.incubyte.sweetshop.entity.User;
import com.incubyte.sweetshop.repository.UserRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthServiceJwtLoginTest {

    @Test
    void shouldReturnJwtTokenOnSuccessfulLogin() {
        // Arrange
        UserRepository userRepository = mock(UserRepository.class);
        JwtUtil jwtUtil = new JwtUtil();
        AuthService authService = new AuthService(userRepository, jwtUtil);

        AuthRequest request = new AuthRequest();
        request.setUsername("john");
        request.setPassword("password");

        User user = new User("john", "password");
        when(userRepository.findByUsername("john")).thenReturn(user);

        // Act
        AuthResponse response = authService.loginAndGenerateToken(request);

        // Assert
        assertNotNull(response);
        assertNotNull(response.getUsername());
        assertTrue(response.getUsername().length() > 10);
    }
}
