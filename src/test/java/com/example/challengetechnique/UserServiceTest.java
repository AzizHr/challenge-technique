package com.example.challengetechnique;

import com.example.challengetechnique.models.User;
import com.example.challengetechnique.repositories.UserRepository;
import com.example.challengetechnique.services.impl.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void profile_WithExistingUsername_ReturnsUser() {
        // Given
        String username = "testUser";
        User expectedUser = new User();
        expectedUser.setUsername(username);
        when(userRepository.findUserByUsername(username)).thenReturn(Optional.of(expectedUser));

        // When
        User actualUser = userService.profile(username);

        // Then
        assertEquals(expectedUser, actualUser);
    }

    @Test
    void profile_WithNonExistingUsername_ThrowsException() {
        // Given
        String username = "nonExistentUser";
        when(userRepository.findUserByUsername(username)).thenReturn(Optional.empty());

        // When
        // Then
        assertThrows(UsernameNotFoundException.class, () -> userService.profile(username));
    }
}
