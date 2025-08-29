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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.capstoneapplication.controller.UserLoginController;
import com.example.capstoneapplication.model.UserCredentials;
import com.example.capstoneapplication.service.UserCredentialService;

@WebMvcTest(UserLoginController.class)
public class UserLoginControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserCredentialService userCredService;

    private final UserCredentials testActiveUser = new UserCredentials (1L, "test", "testpass", 1);
    private final UserCredentials testInactiveUser = new UserCredentials (2L, "inactive", "testpass", 0);
    private final UserCredentials testInvalidUser = new UserCredentials (-1L, "none", "none", 0);

    private String jsonContent = "{\r\n" + //
            "\"id\": 2,\r\n" + //
            "\"username\": \"asdfasdf\",\r\n" + //
            "\"password\": 234,\r\n" + //
            "\"is_active\": \"sdfasdf\"\r\n" + //
            "}";

    @Test
    void test_login_inactive_user () throws Exception {
        when (userCredService.findByUser(any(UserCredentials.class)))
            .thenReturn (testInactiveUser);

        int statusResult = mockMvc.perform (MockMvcRequestBuilders.post ("/api/login").contentType (MediaType.APPLICATION_JSON)
        .content (jsonContent))
        .andReturn ()
        .getResponse ()
        .getStatus ();

        assertEquals(400, statusResult);
    }

    @Test
    void test_login_active_user () throws Exception {
        when (userCredService.findByUser (any(UserCredentials.class)))
            .thenReturn (testActiveUser);

        mockMvc.perform (MockMvcRequestBuilders.post ("/api/login").contentType (MediaType.APPLICATION_JSON)
        .content (jsonContent))
        .andExpect (status ().isOk ());
    }

    @Test
    void test_login_wrong_user () throws Exception {
        when (userCredService.findByUser (any(UserCredentials.class)))
            .thenReturn (testInvalidUser);

        int statusResult = mockMvc.perform (MockMvcRequestBuilders.post ("/api/login").contentType (MediaType.APPLICATION_JSON)
        .content (jsonContent))
        .andReturn ()
        .getResponse ()
        .getStatus ();

        assertEquals(400, statusResult);
    }
}
