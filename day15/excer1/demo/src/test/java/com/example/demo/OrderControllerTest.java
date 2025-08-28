
package com.example.demo;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(OrderController.class)
public class OrderControllerTest {
  @Autowired
  private MockMvc mockMvc;
  @MockitoBean
  private OrderService orderService;

  @Test
  void testCreateOrder() throws Exception {
    when(orderService.createOrder(any(Order.class))).thenReturn(new Order(1L,
        "Laptop", 999.99, "CONFIRMED"));
    mockMvc.perform(post("/order").contentType(MediaType.APPLICATION_JSON).content("""
        {
        "name": "Laptop",
        "price": 999.99,
        "status": "CONFIRMED"
        }
        """))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1L))
        .andExpect(jsonPath("$.name").value("Laptop"))
        .andExpect(jsonPath("$.price").value(999.99))
        .andExpect(jsonPath("$.status").value("CONFIRMED"));
    ;
  }
}
