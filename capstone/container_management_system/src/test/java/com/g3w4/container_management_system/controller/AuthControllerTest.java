package com.g3w4.container_management_system.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void test_given_user_inputs_valid_credentials_to_the_application_when_logging_in_then_user_should_generate_JWT_token_and_return_status_of_200_ok() throws Exception {
        String requestBody = """
            {
                "username": "testuser",
                "password": "password123"
            }
            """;

        mockMvc.perform(MockMvcRequestBuilders.post("/auth/login")
                .contentType(APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").exists());
    }

    @Test
    void test_given_user_inputs_wrong_credentials_to_the_application_when_logging_in_then_application_should_return_status_of_401_unauthorized() {

    }

    @Test
    void test_given_user_inputs_only_username_to_the_application_when_logging_in_then_application_should_return_status_of_400_badRequest() {

    }
}
