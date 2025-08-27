package com.example.testexcercise.service;

// --- OrderServiceIntegrationTest.java ---
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;

import com.example.testexercise.model.Order;
import com.example.testexercise.service.OrderService;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = OrderService.class)
@AutoConfigureWireMock(port = 8081)
public class OrderServiceIntegrationTest {
    @Autowired private OrderService orderService;
    @Test
    void testProcessPaymentSuccess() {
        stubFor(post(urlEqualTo("/payments/process"))
                .willReturn(aResponse().withStatus(200).withBody("{ \"status\": \"SUCCESS\" }")));
        Order order = new Order(1L, "Laptop", 999.99, "CONFIRMED");
        String paymentStatus = orderService.processPayment(order);
        assertThat(paymentStatus).isEqualTo("SUCCESS");
    }
}