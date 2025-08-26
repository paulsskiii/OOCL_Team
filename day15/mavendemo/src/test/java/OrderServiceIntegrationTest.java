
// --- OrderServiceIntegrationTest.java ---
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.Order;
import com.example.OrderService;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

// @SpringBootTest
@AutoConfigureWireMock(port = 8081)
public class OrderServiceIntegrationTest {
    @Autowired
    private OrderService orderService;

    @Test
    void testProcessPaymentSuccess() {
        stubFor(post(urlEqualTo("/payments/process"))
                .willReturn(aResponse().withStatus(200).withBody("{ \"status\": \"SUCCESS\" }")));
        Order order = new Order("Laptop", 999.99);
        String paymentStatus = orderService.processPayment(order);
        assertEquals("SUCCESS", paymentStatus);

    }
}