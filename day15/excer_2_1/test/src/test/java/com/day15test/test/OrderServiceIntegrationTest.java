// package com.day15test.test;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;

// import com.day15test.test.model.Order;
// import com.day15test.test.service.OrderService;

// import static org.junit.jupiter.api.Assertions.*;
// import static org.assertj.core.api.Assertions.assertThat;

// @SpringBootTest
// @AutoConfigureWireMock(port = 8081)
// public class OrderServiceIntegrationTest {
//     @Autowired private OrderService orderService;
//     @Test
//     void testProcessPaymentSuccess() {
//         stubFor(post(urlEqualTo("/payments/process"))
//                 .willReturn(aResponse().withStatus(200).withBody("{ \"status\": \"SUCCESS\" }")));
//         Order order = new Order("Laptop", 999.99);
//         String paymentStatus = orderService.processPayment(order);
//         assertThat(paymentStatus).isEqualTo("SUCCESS");
//     }
// }