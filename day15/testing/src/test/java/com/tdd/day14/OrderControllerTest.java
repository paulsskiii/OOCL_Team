package com.tdd.day14;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// --- OrderControllerTest.java (@WebMvcTest) ---
@WebMvcTest(OrderController.class)
public class OrderControllerTest {
    @Autowired private MockMvc mockMvc;
    @MockBean private OrderService orderService;
    
    @Test
    void testCreateOrder() throws Exception {
        when(orderService.createOrder(any(Order.class))).thenReturn(new Order(1L, "Laptop", 999.99, "CONFIRMED"));
        String orderJson = "{\"product\":\"Laptop\",\"price\":999.99}";
        mockMvc.perform(post("/orders").contentType(MediaType.APPLICATION_JSON).content(orderJson))
               .andExpect(status().isOk());
    }
}
