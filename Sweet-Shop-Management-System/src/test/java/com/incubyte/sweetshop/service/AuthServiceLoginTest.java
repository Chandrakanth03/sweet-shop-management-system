package com.incubyte.sweetshop.service;

import com.incubyte.sweetshop.dto.AuthRequest;
import com.incubyte.sweetshop.entity.User;
import com.incubyte.sweetshop.exception.UserNotFoundException;
import com.incubyte.sweetshop.repository.UserRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthServiceLoginTest {

    @Test
    void shouldLoginUserSuccessfully() {
        // Arrange
        UserRepository userRepository = mock(UserRepository.class);
        AuthService authService = new AuthService(userRepository);

        AuthRequest request = new AuthRequest();
        request.setUsername("john");
        request.setPassword("password");

        User storedUser = new User("john", "password");

        when(userRepository.findByUsername("john")).thenReturn(storedUser);

        // Act
        User loggedInUser = authService.login(request);

        // Assert
        assertNotNull(loggedInUser);
        assertEquals("john", loggedInUser.getUsername());
    }
}
