// --- OrderServiceIntegrationTest.java ---
package com.example.day15_spring_activity2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;

import com.example.day15_spring_activity2.model.Order;
import com.example.day15_spring_activity2.service.OrderService;

@SpringBootTest
@AutoConfigureWireMock(port = 8081)
public class OrderServiceIntegrationTest {
    @Autowired private OrderService orderService;
    // @Test
    // void testProcessPaymentSuccess() {
    //     stubFor(post(urlEqualTo("/payments/process"))
    //             .willReturn(aResponse().withStatus(200).withBody("{ \"status\": \"SUCCESS\" }")));
    //     Order order = new Order("Laptop", 999.99);
    //     String paymentStatus = orderService.processPayment(order);
    //     assertEquals(paymentStatus, "SUCCESS");
    // }
}
