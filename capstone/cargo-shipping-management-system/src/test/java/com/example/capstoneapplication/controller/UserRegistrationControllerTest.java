package com.example.capstoneapplication.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester.MockMvcRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.capstoneapplication.model.UserCredentials;
import com.example.capstoneapplication.service.UserCredentialService;

@WebMvcTest(UserRegistrationController.class)
public class UserRegistrationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserCredentialService userCredService;

    private final UserCredentials testNewUser = new UserCredentials (1L, "test", "testpass", 1);
    private final UserCredentials testInactiveUser = new UserCredentials (2L, "inactive", "testpass", 0);
    private final UserCredentials testInvalidUser = new UserCredentials (-1L, "none", "none", 0);
    private final UserCredentials testExistingUser = new UserCredentials (-1L, "exist", "exist", 0);

    private String jsonContent = "{\r\n" + //
        "\"id\": 2,\r\n" + //
        "\"username\": \"asdfasdf\",\r\n" + //
        "\"password\": 234,\r\n" + //
        "\"is_active\": \"sdfasdf\"\r\n" + //
        "}";

    @Test
    void test_register_new_user () throws Exception {
        when (userCredService.registerUser(any (UserCredentials.class)))
            .thenReturn (testNewUser);

        mockMvc.perform (MockMvcRequestBuilders.post ("/api/register").contentType (MediaType.APPLICATION_JSON)
            .content (jsonContent))
            .andExpect(status ().isOk());
    }

    @Test
    void test_register_existing_username () throws Exception {
        when (userCredService.isUsernameNotExisting(any (UserCredentials.class))).thenReturn (false);
        when (userCredService.registerUser (any (UserCredentials.class))).thenReturn (testExistingUser);
        int statusResult = mockMvc.perform (MockMvcRequestBuilders.post ("/api/register").contentType (MediaType.APPLICATION_JSON)
            .content (jsonContent))
            .andReturn ()
            .getResponse ()
            .getStatus ();

        assertEquals (400, statusResult);
    }

    @Test
    void test_register_inactive_username () throws Exception {
        when (userCredService.isUsernameNotExisting(any (UserCredentials.class))).thenReturn (false);
        when (userCredService.registerUser (any (UserCredentials.class))).thenReturn (testNewUser);
        
        mockMvc.perform (MockMvcRequestBuilders.post ("/api/register").contentType (MediaType.APPLICATION_JSON)
            .content (jsonContent))
            .andExpect(status ().isOk());
    }

}
