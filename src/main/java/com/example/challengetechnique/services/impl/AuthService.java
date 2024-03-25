package com.example.challengetechnique.services.impl;

import com.example.challengetechnique.dtos.request.AuthRequest;
import com.example.challengetechnique.dtos.response.AuthResponse;
import com.example.challengetechnique.models.User;
import com.example.challengetechnique.repositories.UserRepository;
import com.example.challengetechnique.security.authenticators.UserAuthenticator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthResponse login(AuthRequest authRequest) {

        User user = userRepository.findUserByUsername(authRequest.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Email or password not valid"));

        UserAuthenticator userAuthenticator = new UserAuthenticator(user);
        String jwtToken = jwtService.generateToken(userAuthenticator);
        AuthResponse authResponse = new AuthResponse();
        authResponse.setAccessToken(jwtToken);
        return authResponse;
    }
}
