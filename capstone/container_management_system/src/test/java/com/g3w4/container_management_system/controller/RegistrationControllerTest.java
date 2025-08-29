package com.g3w4.container_management_system.controller;



import org.junit.jupiter.api.Test;


public class RegistrationControllerTest {
    @Test
    void test_given_a_user_when_enters_valid_credentials_return_to_login_page() throws Exception {
        
    }

    @Test
    void test_given_a_user_when_enters_non_unique_username_return_error_message() throws Exception {
        //Check DB if there is existing username
        //when(registerUser).then(credentials)


        // when(containerService.addContainers(any(Container.class))).thenReturn(new Registration("qwer","12345"));
        // String orderJson = "{\"username\":\"qwer\",\"password\":\"12345\"}";
        // mockMvc.perform(MockMvcRequestBuilders.post("/api/container").contentType(org.springframework.http.MediaType.APPLICATION_JSON).content(orderJson))
        //         .andExpect(status().isOk())
        //         .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("qwer"))
        //         .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("12345"));


    }

    @Test
    void test_given_a_user_when_enters_non_unique_email_return_error_message() throws Exception {
        
    }

    @Test
    void test_given_a_user_when_enters_weak_password_return_error_message() throws Exception {
        
    }

    @Test
    void test_given_a_user_when_enters_not_valid_contact_number_return_error_message() throws Exception {
        
    }

    @Test
    void test_given_a_user_when_enters_special_characters_in_first_name_field_return_error_messsage() throws Exception {
        
    }

    @Test
    void test_given_a_user_when_enters_special_characters_in_last_name_field_return_error_messsage() throws Exception {
        
    }
}
