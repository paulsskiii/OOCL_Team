// --- OrderControllerTest.java (@WebMvcTest) ---
package com.example.day15_spring_activity2;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.day15_spring_activity2.controller.OrderController;
import com.example.day15_spring_activity2.model.Order;
import com.example.day15_spring_activity2.service.OrderService;

@WebMvcTest(OrderController.class)
public class OrderControllerTest {
    @Autowired private MockMvc mockMvc;
    @MockitoBean private OrderService orderService;

//     @Test
//     void testCreateOrder() throws Exception {
//         when(orderService.createOrder(any(Order.class))).thenReturn(new Order(1L, "Laptop", 999.99, "CONFIRMED"));
//         mockMvc.perform(post("/orders").contentType(MediaType.APPLICATION_JSON).content("..."))
//                .andExpect(status().isOk());
//     }
}
