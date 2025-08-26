// package com.example.testing;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;

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