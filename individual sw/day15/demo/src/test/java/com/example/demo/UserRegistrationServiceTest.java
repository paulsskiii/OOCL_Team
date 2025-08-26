package com.example.demo;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.EmailService;
import com.example.demo.service.PasswordValidator;
import com.example.demo.service.UserRegistrationService;
;

@ExtendWith(MockitoExtension.class)
public class UserRegistrationServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private EmailService emailService;

    @Mock
    private PasswordValidator passwordValidator;

    @InjectMocks
    private UserRegistrationService userRegistrationService;

    private User sampleUser;

    @BeforeEach
    void setUp() {
        sampleUser = new User();
        sampleUser.setEmail("test@example.com");
    }
    // 1. Positive Test: Successful Registration
    @Test
    void testSuccessfulRegistration() {
        // AAA Pattern
        // Arrange
        when(passwordValidator.isValid(anyString())).thenReturn(true);
        when(userRepository.findByEmail(anyString())).thenReturn(null);

        // Act
        boolean result = userRegistrationService.registerUser("newuser@example.com", "SecurePassword123!");

        // Assert
        assertTrue(result);
        verify(userRepository, times(1)).save(any(User.class));
        verify(emailService, times(1)).sendRegistrationEmail("newuser@example.com");
    }

    // 2. Negative Test: Invalid Password
    @Test
    void testRegistrationFailsWithInvalidPassword() {
        // Arrange
        when(passwordValidator.isValid(anyString())).thenReturn(false);

        // Act
        boolean result = userRegistrationService.registerUser("test@example.com", "weak");

        // Assert
        assertFalse(result);
        verify(userRepository, never()).findByEmail(anyString());
        verify(emailService, never()).sendRegistrationEmail(anyString());
    }

    // 3. Negative Test: User Already Exists
    @Test
    void testRegistrationFailsIfUserExists() {
        // Arrange
        when(passwordValidator.isValid(anyString())).thenReturn(true);
        when(userRepository.findByEmail(anyString())).thenReturn(sampleUser);

        // Act
        boolean result = userRegistrationService.registerUser("test@example.com", "ValidPassword123");

        // Assert
        assertFalse(result);
        verify(userRepository, times(1)).findByEmail("test@example.com");
        verify(userRepository, never()).save(any(User.class));
        verify(emailService, never()).sendRegistrationEmail(anyString());
    }
}

