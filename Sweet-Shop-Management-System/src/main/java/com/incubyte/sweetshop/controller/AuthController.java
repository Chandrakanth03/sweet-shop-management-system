package com.incubyte.sweetshop.controller;

import com.incubyte.sweetshop.dto.AuthRequest;
import com.incubyte.sweetshop.dto.AuthResponse;
import com.incubyte.sweetshop.dto.RegisterRequest;
import com.incubyte.sweetshop.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // ✅ REGISTER API (PUBLIC)
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        authService.register(request);
        return ResponseEntity.ok("User registered successfully");
    }

    // ✅ LOGIN API (PUBLIC)
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        String token = authService.login(request);
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
