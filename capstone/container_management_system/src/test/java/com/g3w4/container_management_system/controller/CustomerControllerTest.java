package com.g3w4.container_management_system.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.g3w4.container_management_system.model.Customer;
import com.g3w4.container_management_system.service.ContainerService;
import com.g3w4.container_management_system.service.CustomerService;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private CustomerService customerService;


    @Test
    void test_given_a_user_when_enters_valid_credentials_return_to_login_page() throws Exception {
        when(customerService.addCustomers(any(Customer.class))).thenReturn(new Customer(1, "rhel", "calsan", "rc@gamil.com", "45648979"));
        String orderJson ="{\r\n" + 
        "\"customerId\": 1,\r\n" + 
        "\"firstName\": \"rhel\",\r\n" + 
        "\"lastName\": calsan,\r\n" + 
        "\"email\": \"rc@gamil.com\"\r\n" + 
        "\"contactNo\": \"45648979\"\r\n" + 
        "}";
        // String orderJson = "{\"customerId\":1,\"firstName\":\"rhel\",\"lastName\":\"calsan\",\"email\":\"rc@gamil.com\",\"contactNo\":\"45648979\"}";
        

        int statusResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/customer").contentType(MediaType.APPLICATION_JSON)
        .content (orderJson))
        .andReturn()
        .getResponse()
        .getStatus();

        assertEquals(201, statusResult);

        // when(customerService.addCustomers(any(Customer.class))).thenReturn(new Customer(1, "rhel", "calsan", "rc@gamil.com", "45648979"));
        // String orderJson = "{\"customerId\":1,\"firstName\":\"rhel\",\"lastName\":\"calsan\",\"email\":\"rc@gamil.com\",\"contactNo\":\"45648979\"}";
        // mockMvc.perform(MockMvcRequestBuilders.post("/api/container").contentType(org.springframework.http.MediaType.APPLICATION_JSON).content(orderJson))
        //         .andExpect(status().isOk())
        //         .andExpect(MockMvcResultMatchers.jsonPath("$.customerId").value(1))
        //         .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("rhel"))
        //         .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("calsan"))
        //         .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("rc@gamil.com"))
        //         .andExpect(MockMvcResultMatchers.jsonPath("$.contactNo").value("45648979"));
 

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

        // String requestBody = """
        //     {
        //         "username": "testuser",
        //         "password": "password123"
        //     }
        //     """;

        // mockMvc.perform(MockMvcRequestBuilders.post("/auth/login")
        //         .contentType(APPLICATION_JSON)
        //         .content(requestBody))
        //         .andExpect(status().isCreated())
        //         .andExpect(jsonPath("$.token").exists());

        // mockMvc.perform(MockMvcRequestBuilders.post("/auth/login")
        //         .contentType(APPLICATION_JSON)
        //         .content(requestBody))
        //         .andExpect(status().isBadRequest());
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




