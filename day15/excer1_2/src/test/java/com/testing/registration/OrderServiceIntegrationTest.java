package day15.excer1_2.src.test.java.com.testing.registration;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.ActiveProfiles;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@WireMockTest(httpPort = 9091)
public class OrderServiceIntegrationTest {

    @Autowired
    private OrderService orderService;

    @Test
    void testProcessPaymentSuccess() {
        stubFor(post(urlEqualTo("/payments/process"))
                .willReturn(aResponse().withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{ \"status\": \"SUCCESS\" }")));

        Order order = new Order("Laptop", 999.99);
        String paymentStatus = orderService.processPayment(order);

        assertThat(paymentStatus).isEqualTo("SUCCESS");
    }
}

