package com.example.capstoneapplication.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.capstoneapplication.model.UserCredentials;
import com.example.capstoneapplication.repository.UserCredentialsRepository;

@ExtendWith(MockitoExtension.class)
public class UserCredentialsServiceTest {
    @Mock
    private UserCredentialsRepository userCredRepo;

    @InjectMocks
    private UserCredentialService userCredService;

    private UserCredentials newUser = new UserCredentials (1L, "test", "testUser", 1);

    @Test
    void test_register_new_valid_user () {
        when (userCredRepo.findByActiveUsername (any (String.class))).thenReturn (Optional.empty());
        when (userCredRepo.save (any (UserCredentials.class))).thenReturn (newUser);
        UserCredentials createdUser = userCredService.registerUser(newUser);

        assertEquals(newUser, createdUser);        
    }

    @Test
    void test_register_existing_username () {
        when (userCredRepo.findByActiveUsername (any (String.class))).thenReturn (Optional.of (newUser));
        
        UserCredentials createdUser = userCredService.registerUser (newUser);

        assertEquals (-1L, createdUser.getId ());
        assertEquals ("exist", createdUser.getUsername ());
    }
}
