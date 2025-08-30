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
import com.example.capstoneapplication.model.UserCredential;
import com.example.capstoneapplication.service.UserService;

@WebMvcTest(UserLoginController.class)
public class UserLoginControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private final UserCredential testActiveUser = new UserCredential (1L, "test", "testpass", 1);
    private final UserCredential testInactiveUser = new UserCredential (2L, "inactive", "testpass", 0);
    private final UserCredential testInvalidUser = new UserCredential (-1L, "none", "none", 0);

    @Test
    void test_login_inactive_user () throws Exception {
    }

    @Test
    void test_login_active_user () throws Exception {

    }

    @Test
    void test_login_wrong_user () throws Exception {
    }
}
