package com.example.challengetechnique;

import com.example.challengetechnique.exceptions.InvalidCountValueException;
import com.example.challengetechnique.models.User;
import com.example.challengetechnique.services.impl.UsersGeneratorServiceImpl;
import com.example.challengetechnique.utils.FakeUserGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class UsersGeneratorServiceImplTest {

    @Mock
    private FakeUserGenerator fakeUserGenerator;

    @InjectMocks
    private UsersGeneratorServiceImpl usersGeneratorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void generateUsers_ReturnsCorrectNumberOfUsers() throws InvalidCountValueException {
        // Given
        int count = 5;
        User fakeUser = new User(); // Create a fake user
        when(fakeUserGenerator.generate(fakeUser)).thenReturn(fakeUser); // Mock the behavior of FakeUserGenerator

        // When
        List<User> users = usersGeneratorService.generateUsers(count);

        // Then
        assertEquals(count, users.size()); // Check if the number of generated users matches the expected count
    }
}
