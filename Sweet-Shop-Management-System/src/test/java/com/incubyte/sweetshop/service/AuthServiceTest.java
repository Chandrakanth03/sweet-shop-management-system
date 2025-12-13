package com.incubyte.sweetshop.service;

import com.incubyte.sweetshop.dto.RegisterRequest;
import com.incubyte.sweetshop.entity.User;
import com.incubyte.sweetshop.exception.UserAlreadyExistsException;
import com.incubyte.sweetshop.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthServiceTest {

    @Test
    void shouldRegisterNewUserSuccessfully() {
        // Arrange
        UserRepository userRepository = mock(UserRepository.class);
        AuthService authService = new AuthService(userRepository);

        RegisterRequest request = new RegisterRequest();
        request.setUsername("john");
        request.setPassword("password");

        when(userRepository.existsByUsername("john")).thenReturn(false);
        when(userRepository.save(any(User.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));  // <-- added this

        // Act
        User savedUser = authService.register(request);

        // Assert
        assertNotNull(savedUser);
        assertEquals("john", savedUser.getUsername());
    }


    @Test
    void shouldThrowExceptionWhenUserAlreadyExists() {
        // Arrange
        UserRepository userRepository = mock(UserRepository.class);
        AuthService authService = new AuthService(userRepository);

        RegisterRequest request = new RegisterRequest();
        request.setUsername("john");
        request.setPassword("password");

        when(userRepository.existsByUsername("john")).thenReturn(true);

        // Act + Assert
        assertThrows(UserAlreadyExistsException.class, () -> authService.register(request));
    }
}
