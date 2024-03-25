package com.example.challengetechnique.controllers;

import com.example.challengetechnique.dtos.request.AuthRequest;
import com.example.challengetechnique.dtos.response.AuthResponse;
import com.example.challengetechnique.services.impl.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    // Endpoint to handle user login
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
        // Delegate login operation to AuthService and return response entity
        return ResponseEntity.ok(authService.login(authRequest));
    }
}
