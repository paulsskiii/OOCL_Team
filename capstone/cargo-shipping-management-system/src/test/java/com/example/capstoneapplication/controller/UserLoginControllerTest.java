package com.example.capstoneapplication.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.capstoneapplication.model.UserCredential;
import com.example.capstoneapplication.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(UserLoginController.class)
public class UserLoginControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    private final UserCredential validLogin = new UserCredential ("test", "testpass");

    @Test
    void test_login_active_user () throws Exception {
        Map<String, Object> loginSuccessMap = new HashMap<>();
        loginSuccessMap.put ("success", true);
        loginSuccessMap.put ("message", "login_success");

        when (userService.loginUser (validLogin)).thenReturn (loginSuccessMap);

        mockMvc.perform(MockMvcRequestBuilders.post ("/api/login").contentType(MediaType.APPLICATION_JSON)
        .content (objectMapper.writeValueAsString (validLogin)))
        .andExpect (jsonPath("$.success").value (true))
        .andExpect (jsonPath("$.message").value ("login_success"))
        .andExpect (status ().isOk ());

        verify (userService, times(1)).loginUser (validLogin);
    }

    @Test
    void test_login_inactive_user_or_wrong_credentials () throws Exception {
        Map<String, Object> loginFailMap = new HashMap<>();
        loginFailMap.put ("success", false);
        loginFailMap.put ("message", "login_fail");

        when (userService.loginUser (validLogin)).thenReturn (loginFailMap);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post ("/api/login").contentType(MediaType.APPLICATION_JSON)
        .content (objectMapper.writeValueAsString (validLogin)))
        .andExpect (jsonPath("$.success").value (false))
        .andExpect (jsonPath("$.message").value ("login_fail"))
        .andReturn ();

        assertEquals (401, mvcResult.getResponse ().getStatus ());
        verify (userService, times(1)).loginUser (validLogin);
    }

    @Test
    void test_login_other_error_occurred () throws Exception {
        Map<String, Object> loginFailMap = new HashMap<>();
        loginFailMap.put ("success", false);
        loginFailMap.put ("message", "login_error");

        when (userService.loginUser (validLogin)).thenReturn (loginFailMap);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post ("/api/login").contentType(MediaType.APPLICATION_JSON)
        .content (objectMapper.writeValueAsString (validLogin)))
        .andExpect (jsonPath("$.success").value (false))
        .andExpect (jsonPath("$.message").value ("login_error"))
        .andReturn ();

        assertEquals (500, mvcResult.getResponse ().getStatus ());
        verify (userService, times(1)).loginUser (validLogin);
    }

    @Test
    void test_login_bad_json () throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post ("/api/login").contentType(MediaType.APPLICATION_JSON)
        .content ("{\"sadfasd\": \"" + "asdfasdf\"}"))
        .andExpect (jsonPath("$.success").value (false))
        .andExpect (jsonPath("$.message").value ("bad_error"))
        .andReturn ();

        assertEquals (400, mvcResult.getResponse ().getStatus ());
        verify (userService, times(0)).loginUser (validLogin);
    }
}
