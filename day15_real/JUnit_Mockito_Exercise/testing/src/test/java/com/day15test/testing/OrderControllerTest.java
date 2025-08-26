package com.day15test.testing;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.day15test.testing.controller.OrderController;
import com.day15test.testing.model.Orders;
import com.day15test.testing.service.OrderService;

// --- OrderControllerTest.java (@WebMvcTest) ---
@WebMvcTest(OrderController.class)
public class OrderControllerTest {
    @Autowired private MockMvc mockMvc;
    @MockBean private OrderService orderService;
    @Test
    void testCreateOrder() throws Exception {
        when(orderService.createOrder(any(Orders.class))).thenReturn(new Order(1L, "Laptop", 999.99, "CONFIRMED"));
        mockMvc.perform(post("/orders").contentType(MediaType.APPLICATION_JSON).content("..."))
               .andExpect(status().isOk());
    }
}
