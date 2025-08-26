// --- OrderServiceIntegrationTest.java ---
package com.day15test.testing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;

import com.day15test.testing.model.Order;
import com.day15test.testing.service.OrderService;

// import org.springframework.cloud.spring.cloud.starter.stub.runner;
import static com.github.tomakehurst.wiremock.client.WireMock.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
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