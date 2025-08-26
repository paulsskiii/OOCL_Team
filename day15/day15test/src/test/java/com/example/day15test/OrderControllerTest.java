package com.example.day15test;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.day15test.controller.OrderController;
import com.example.day15test.model.Order;
import com.example.day15test.service.OrderService;

// --- OrderControllerTest.java (@WebMvcTest) ---
@WebMvcTest(controllers = OrderController.class)
@Import(OrderController.class)
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private OrderService orderService;

    @Test
    void testCreateOrder() throws Exception {
        when(orderService.createOrder(any(Order.class))).thenReturn(new Order(1L, "Laptop", 999.99, "CONFIRMED"));
        String orderJson = "{\"itemName\":\"Laptop\",\"price\":999.99}";
        mockMvc.perform(MockMvcRequestBuilders.post("/orders").contentType(org.springframework.http.MediaType.APPLICATION_JSON).content(orderJson))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.itemName").value("Laptop"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(999.99))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("CONFIRMED"));
    }
}
