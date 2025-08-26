package com.day15test.test;

// --- OrderControllerTest.java (@WebMvcTest) ---

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
 
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.day15test.test.controller.OrderController;
import com.day15test.test.model.Order;
import com.day15test.test.service.OrderService;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 
@WebMvcTest(OrderController.class)
public class OrderControllerTest {
    @Autowired private MockMvc mockMvc;
    @MockBean private OrderService orderService;
    @Test
    void testCreateOrder() throws Exception {
        when(orderService.createOrder(any(Order.class))).thenReturn(new Order(1L, "Laptop", 999.99, "CONFIRMED"));
        mockMvc.perform(MockMvcRequestBuilders.post("/orders").contentType(MediaType.APPLICATION_JSON).content("..."))
                .andExpect(status().isOk());
    }
}
