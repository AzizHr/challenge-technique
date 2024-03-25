package com.example.challengetechnique;

import com.example.challengetechnique.dtos.request.AuthRequest;
import com.example.challengetechnique.dtos.response.AuthResponse;
import com.example.challengetechnique.models.User;
import com.example.challengetechnique.repositories.UserRepository;
import com.example.challengetechnique.security.authenticators.UserAuthenticator;
import com.example.challengetechnique.services.impl.AuthService;
import com.example.challengetechnique.services.impl.JwtService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private JwtService jwtService;

    @InjectMocks
    private AuthService authService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void login_ValidCredentials_ReturnsAccessToken() {
        // Given
        AuthRequest authRequest = new AuthRequest("test_username", "test_password");
        User user = new User();
        user.setUsername("test_username");
        user.setPassword("hashed_password");

        // Mocking behavior of UserRepository
        when(userRepository.findUserByUsername("test_username")).thenReturn(java.util.Optional.of(user));

        // Mocking behavior of JwtService
        when(jwtService.generateToken(any(UserAuthenticator.class))).thenReturn("mocked_jwt_token");

        // When
        AuthResponse authResponse = authService.login(authRequest);

        // Then
        assertEquals("mocked_jwt_token", authResponse.getAccessToken());
    }

    @Test
    void login_InvalidCredentials_ThrowsException() {
        // Given
        AuthRequest authRequest = new AuthRequest("invalid_username", "invalid_password");

        // Mocking behavior of UserRepository (returning empty optional)
        when(userRepository.findUserByUsername("invalid_username")).thenReturn(java.util.Optional.empty());

        // Then (verify if UsernameNotFoundException is thrown)
        assertThrows(UsernameNotFoundException.class, () -> {
            authService.login(authRequest);
        });
    }
}
