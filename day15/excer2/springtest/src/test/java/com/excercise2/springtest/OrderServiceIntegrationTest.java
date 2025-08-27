package com.excercise2.springtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;


import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;

// --- OrderServiceIntegrationTest.java ---
@SpringBootTest
@AutoConfigureWireMock(port = 0)
public class OrderServiceIntegrationTest {
    @Autowired private OrderService orderService;
    @Test
    void testProcessPaymentSuccess() {
        stubFor(post(urlEqualTo("/payments/process"))
                .willReturn(aResponse().withStatus(200).withBody("{ \"status\": \"SUCCESS\" }")));
        Order order = new Order(0, "Laptop", 999.99, null);
        String paymentStatus = orderService.processPayment(order);
        assertThat(paymentStatus).isEqualTo("SUCCESS");
    }
}