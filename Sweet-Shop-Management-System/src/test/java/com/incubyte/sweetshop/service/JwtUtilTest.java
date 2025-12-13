package com.incubyte.sweetshop.service;

import com.incubyte.sweetshop.entity.User;
import com.incubyte.sweetshop.config.JwtUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JwtUtilTest {

    @Test
    void shouldGenerateJwtTokenForValidUser() {
        // Arrange
        JwtUtil jwtUtil = new JwtUtil();
        User user = new User("john", "password");

        // Act
        String token = jwtUtil.generateToken(user);

        // Assert
        assertNotNull(token);
        assertTrue(token.length() > 10);
    }
}

