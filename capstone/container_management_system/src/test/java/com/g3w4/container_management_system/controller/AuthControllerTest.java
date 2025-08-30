package com.g3w4.container_management_system.controller;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.g3w4.container_management_system.dto.LoginUserDto;
import com.g3w4.container_management_system.model.Users;
import com.g3w4.container_management_system.service.AuthenticationService;
import com.g3w4.container_management_system.service.JwtService;

@WebMvcTest(AuthController.class)  // only loads your controller + MVC infra
@AutoConfigureMockMvc(addFilters = false) // disable security filters for simplicity
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private AuthenticationService authenticationService;

    @MockitoBean
    private JwtService jwtService;

    // @MockitoBean
    // private UserDetailsService userDetailsService;
    // @MockitoBean
    // private PasswordEncoder passwordEncoder;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void test_given_user_inputs_valid_credentials_to_the_application_when_logging_in_then_user_should_generate_JWT_token_and_return_status_of_200_ok() throws Exception {
        Users mockUser = new Users();

        when(authenticationService.authenticate(any())).thenReturn(mockUser);
        when(jwtService.generateToken(any(Users.class))).thenReturn("mock-jwt-token");
        when(jwtService.getExpirationTime()).thenReturn(3600L);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/login")
                .contentType(APPLICATION_JSON)
                .content("{\"username\":\"test\",\"password\":\"pass\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value("mock-jwt-token"))
                .andExpect(jsonPath("$.expiresIn").value(3600L));
    }

    @Test
    void test_given_user_inputs_wrong_credentials_to_the_application_when_logging_in_then_application_should_return_status_of_401_unauthorized() throws Exception {
        when(authenticationService.authenticate(any()))
                .thenThrow(new BadCredentialsException("Invalid credentials"));

        LoginUserDto dto = new LoginUserDto("john", "wrongpassword");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/login")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isUnauthorized())
                .andExpect(content().string("Invalid credentials"));;
    }

    @Test
    void test_given_user_inputs_only_username_to_the_application_when_logging_in_then_application_should_return_status_of_400_badRequest() throws Exception {
        String requestBody = """
            {
                "username": "testuser"
            }
            """;

        mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/login")
                .contentType(APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isBadRequest());
    }
}
