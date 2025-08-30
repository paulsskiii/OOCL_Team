package com.example.capstoneapplication.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.capstoneapplication.model.UserCredential;
import com.example.capstoneapplication.model.UserInformation;
import com.example.capstoneapplication.repository.UserCredentialRepository;
import com.example.capstoneapplication.repository.UserInformationRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserCredentialRepository userCredRepo;
    @Mock
    private UserInformationRepository userInfoRepo;

    @InjectMocks
    private UserService userService;

    private final UserCredential validUserCred = new UserCredential (1L, "test", "test_password", 1);
    private final UserInformation validUserInfo = new UserInformation (1L, "test", "test_password", 1L);

    private final UserCredential newUserCred = new UserCredential ("test", "test_password");
    private final UserInformation newUserInfo = new UserInformation ("test", "test_password", 1L);

    private Map<String, Object> checkResultMap;

    @BeforeEach
    void setupBeforeEach () {
        checkResultMap = new HashMap<> ();
    }


    @Test
    void test_service_register_existing_username () {
        when (userCredRepo.findByActiveUsername(any (String.class))).thenReturn (Optional.of (validUserCred));
        when (userInfoRepo.findByActiveEmail(any (String.class))).thenReturn (Optional.empty ());

        checkResultMap = userService.registerUser (validUserCred, validUserInfo);

        assertFalse ((boolean)checkResultMap.get ("success"));
        assertEquals ("username_conflict", checkResultMap.get ("message"));

        verify (userCredRepo, times(0)).save (validUserCred);
        verify (userInfoRepo, times(0)).save (validUserInfo);
    }

    @Test
    void test_service_register_existing_email () {
        when (userCredRepo.findByActiveUsername(any (String.class))).thenReturn (Optional.empty ());
        when (userInfoRepo.findByActiveEmail(any (String.class))).thenReturn (Optional.of (validUserInfo));

        checkResultMap = userService.registerUser (validUserCred, validUserInfo);

        assertFalse ((boolean)checkResultMap.get ("success"));
        assertEquals ("email_conflict", checkResultMap.get ("message"));

        verify (userCredRepo, times(0)).save (validUserCred);
        verify (userInfoRepo, times(0)).save (validUserInfo);
    }

    @Test
    void test_registor_error_checking_username () {
        when (userCredRepo.findByActiveUsername(any (String.class))).thenThrow (new RuntimeException ("DB error username check"));
        when (userInfoRepo.findByActiveEmail(any (String.class))).thenReturn (Optional.empty ());

        checkResultMap = userService.registerUser (validUserCred, validUserInfo);

        assertFalse ((boolean)checkResultMap.get ("success"));
        assertEquals ("db_error", checkResultMap.get ("message"));

        verify (userCredRepo, times(0)).save (validUserCred);
        verify (userInfoRepo, times(0)).save (validUserInfo);
    }

    @Test
    void test_registor_error_checking_email () {
        Map<String, Object> checkResultMap = new HashMap<> ();
        when (userCredRepo.findByActiveUsername(any (String.class))).thenReturn (Optional.empty ());
        when (userInfoRepo.findByActiveEmail(any (String.class))).thenThrow (new RuntimeException ("DB error email check"));

        checkResultMap = userService.registerUser (validUserCred, validUserInfo);

        assertFalse ((boolean)checkResultMap.get ("success"));
        assertEquals ("db_error", checkResultMap.get ("message"));

        verify (userCredRepo, times(0)).save (validUserCred);
        verify (userInfoRepo, times(0)).save (validUserInfo);
    }

    @Test
    void test_service_register_happy () {
        when (userCredRepo.findByActiveUsername(any (String.class))).thenReturn (Optional.empty ());
        when (userCredRepo.save (any (UserCredential.class))).thenReturn (validUserCred);
        when (userInfoRepo.findByActiveEmail(any (String.class))).thenReturn (Optional.empty ());
        when (userInfoRepo.save (any (UserInformation.class))).thenReturn (validUserInfo);

        checkResultMap = userService.registerUser (newUserCred, newUserInfo);

        assertTrue ((boolean)checkResultMap.get ("success"));
        assertEquals ("user_created", checkResultMap.get ("message"));

        verify (userCredRepo, times(1)).save (newUserCred);
        verify (userInfoRepo, times(1)).save (newUserInfo);
    }

    @Test
    void test_login_active_user_happy () {
        when (userCredRepo.findByActiveUsernamePassword (any (String.class), any (String.class))).thenReturn (Optional.of (validUserCred));
        checkResultMap = userService.loginUser (newUserCred);

        assertTrue ((boolean)checkResultMap.get ("success"));
        assertEquals ("login_success", checkResultMap.get ("message"));

        verify (userCredRepo, times(1)).findByActiveUsernamePassword (newUserCred.getUsername (), newUserCred.getPassword ());
    }

    @Test
    void test_login_user_inactive_or_wrong_credentials () {
        when (userCredRepo.findByActiveUsernamePassword (any (String.class), any (String.class))).thenReturn (Optional.empty ());
        checkResultMap = userService.loginUser (newUserCred);

        assertFalse ((boolean)checkResultMap.get ("success"));
        assertEquals ("login_fail", checkResultMap.get ("message"));

        verify (userCredRepo, times(1)).findByActiveUsernamePassword (newUserCred.getUsername (), newUserCred.getPassword ());
    }

    @Test
    void test_login_user_db_error () {
        when (userCredRepo.findByActiveUsernamePassword (any (String.class), any (String.class))).thenThrow (new RuntimeException ("login db error"));
        checkResultMap = userService.loginUser (newUserCred);

        assertFalse ((boolean)checkResultMap.get ("success"));
        assertEquals ("login_error", checkResultMap.get ("message"));

        verify (userCredRepo, times(1)).findByActiveUsernamePassword (newUserCred.getUsername (), newUserCred.getPassword ());
    }
}