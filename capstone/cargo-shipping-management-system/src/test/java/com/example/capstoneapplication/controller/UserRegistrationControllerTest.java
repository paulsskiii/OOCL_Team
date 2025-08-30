package com.example.capstoneapplication.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.print.attribute.standard.Media;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.assertj.MockMvcTester.MockMvcRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.capstoneapplication.model.UserCredential;
import com.example.capstoneapplication.model.UserInformation;
import com.example.capstoneapplication.service.UserService;
import com.example.capstoneapplication.util.UserDetail;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(UserRegistrationController.class)
public class UserRegistrationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    private final UserCredential validUserCred = new UserCredential (1L, "test", "test_password", 1);
    private final UserCredential validUserCredReg = new UserCredential ("test", "test_password", 1);
    private final UserInformation validUserInfo = new UserInformation (1L, "test", "test_password", 1L);
    private final UserInformation validUserInfoReg = new UserInformation ("test", "test_password", 1L);

    private Map<String, Object> registerSuccessResult;
    private Map<String, Object> registerFailResult;

    @BeforeEach
    void setupBeforeEach () {
        registerSuccessResult = new HashMap<> ();
        registerFailResult = new HashMap<> ();

        registerSuccessResult.put ("success", true);
        registerSuccessResult.put ("message", "user_created");
        registerFailResult.put ("success", false);
    }

    @Test
    void test_controller_register_existing_username () throws Exception {
        registerFailResult.put ("message", "username_conflict");
        when (userService.registerUser (validUserCredReg, validUserInfoReg)).thenReturn (registerFailResult);

        UserDetail userDetail = new UserDetail (validUserCredReg, validUserInfoReg);

        MvcResult mvcResult = mockMvc.perform (MockMvcRequestBuilders.post ("/api/register").contentType (MediaType.APPLICATION_JSON)
        .content (objectMapper.writeValueAsString (userDetail)))
        .andExpect (jsonPath ("$.success").value(false))
        .andExpect (jsonPath ("$.message").value ("username_conflict"))
        .andReturn ();

        assertEquals(409, mvcResult.getResponse ().getStatus ());
        
        verify (userService, times(1)).registerUser (validUserCredReg, validUserInfoReg);
    }

    @Test
    void test_controller_register_existing_email () throws Exception {
        registerFailResult.put ("message", "email_conflict");
        when (userService.registerUser (validUserCredReg, validUserInfoReg)).thenReturn (registerFailResult);

        UserDetail userDetail = new UserDetail (validUserCredReg, validUserInfoReg);

        MvcResult mvcResult = mockMvc.perform (MockMvcRequestBuilders.post ("/api/register").contentType (MediaType.APPLICATION_JSON)
        .content (objectMapper.writeValueAsString (userDetail)))
        .andExpect (jsonPath ("$.success").value(false))
        .andExpect (jsonPath ("$.message").value ("email_conflict"))
        .andReturn ();

        assertEquals(409, mvcResult.getResponse ().getStatus ());
        
        verify (userService, times(1)).registerUser (validUserCredReg, validUserInfoReg);
    }

    @Test
    void test_controller_register_db_error () throws Exception {
        registerFailResult.put ("message", "db_error");
        when (userService.registerUser (validUserCredReg, validUserInfoReg)).thenReturn (registerFailResult);

        UserDetail userDetail = new UserDetail (validUserCredReg, validUserInfoReg);

        MvcResult mvcResult = mockMvc.perform (MockMvcRequestBuilders.post ("/api/register").contentType (MediaType.APPLICATION_JSON)
        .content (objectMapper.writeValueAsString (userDetail)))
        .andExpect (jsonPath ("$.success").value(false))
        .andExpect (jsonPath ("$.message").value ("db_error"))
        .andReturn ();

        assertEquals(500, mvcResult.getResponse ().getStatus ());
        
        verify (userService, times(1)).registerUser (validUserCredReg, validUserInfoReg);
    }

    @Test
    void test_controller_register_bad_json_format () throws Exception {
        registerFailResult.put ("message", "error");
        when (userService.registerUser (validUserCredReg, validUserInfoReg)).thenReturn (registerFailResult);

        UserDetail userDetail = new UserDetail (validUserCredReg, validUserInfoReg);

        MvcResult mvcResult = mockMvc.perform (MockMvcRequestBuilders.post ("/api/register").contentType (MediaType.APPLICATION_JSON)
        .content (objectMapper.writeValueAsString (validUserCred)))
        .andExpect (jsonPath ("$.success").value(false))
        .andExpect (jsonPath ("$.message").value ("error"))
        .andReturn ();

        assertEquals(400, mvcResult.getResponse ().getStatus ());
        
        verify (userService, times(0)).registerUser (validUserCredReg, validUserInfoReg);
    }

    @Test
    void test_controller_register_happy () throws Exception {
        when (userService.registerUser (validUserCredReg, validUserInfoReg)).thenReturn (registerSuccessResult);

        UserDetail userDetail = new UserDetail (validUserCredReg, validUserInfoReg);

        MvcResult mvcResult = mockMvc.perform (MockMvcRequestBuilders.post ("/api/register").contentType (MediaType.APPLICATION_JSON)
        .content (objectMapper.writeValueAsString (userDetail)))
        .andExpect (jsonPath ("$.success").value(true))
        .andExpect (jsonPath ("$.message").value ("user_created"))
        .andReturn ();

        assertEquals(201, mvcResult.getResponse ().getStatus ());
        
        verify (userService, times(1)).registerUser (validUserCredReg, validUserInfoReg);
    }



}
