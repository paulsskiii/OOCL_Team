//package day15.test.testing;
//
//import day15.test.testing.user.*;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.*;
//
//@SpringBootTest
//@ExtendWith(MockitoExtension.class)
//public class UserRegistrationServiceTest {
//
//    @Mock
//    private UserRepository userRepository;
//
//    @Mock
//    private EmailService emailService;
//
//    @Mock
//    private PasswordValidator passwordValidator;
//
//    @InjectMocks
//    private UserRegistrationService userRegistrationService;
//
//    private User sampleUser;
//
//    @BeforeEach
//    void setUp() {
//        sampleUser = new User();
//        sampleUser.setEmail("test@example.com");
//    }
//
//    // --- Test Scenarios ---
//
//    // 1. Positive Test: Successful Registration
//    @Test
//    void testSuccessfulRegistration() {
//        // AAA Pattern
//        // Arrange
//        // when () is basically making sure that when the mocked dependencies are called in the mock tests, it returns a certain value
//        when(passwordValidator.isValid(anyString())).thenReturn(true);
//        when(userRepository.findByEmail(anyString())).thenReturn(null);
//
//        // Act
//        boolean result = userRegistrationService.registerUser("newuser@example.com", "SecurePassword123!");
//
//        // Assert
//        assertTrue(result);
//        verify(userRepository, times(1)).save(any(User.class));
//        verify(emailService, times(1)).sendRegistrationEmail("newuser@example.com");
//    }
//
//    // 2. Negative Test: Invalid Password
//    @Test
//    void testRegistrationFailsWithInvalidPassword() {
//        // Arrange
//        when(passwordValidator.isValid(anyString())).thenReturn(false);
//
//        // Act
//        boolean result = userRegistrationService.registerUser("test@example.com", "weak");
//
//        // Assert
//        assertFalse(result);
//        verify(userRepository, never()).findByEmail(anyString());
//        verify(emailService, never()).sendRegistrationEmail(anyString());
//    }
//
//    // 3. Negative Test: User Already Exists
//    @Test
//    void testRegistrationFailsIfUserExists() {
//        // Arrange
//        when(passwordValidator.isValid(anyString())).thenReturn(true);
//        when(userRepository.findByEmail(anyString())).thenReturn(sampleUser);
//
//        // Act
//        boolean result = userRegistrationService.registerUser("test@example.com", "ValidPassword123");
//
//        // Assert
//        assertFalse(result);
//        verify(userRepository, times(1)).findByEmail("test@example.com");
//        verify(userRepository, never()).save(any(User.class));
//        verify(emailService, never()).sendRegistrationEmail(anyString());
//    }
//
//}
