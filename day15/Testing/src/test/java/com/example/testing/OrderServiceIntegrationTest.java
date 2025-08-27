// // --- OrderServiceIntegrationTest.java ---
 @SpringBootTest
 @AutoConfigureWireMock(port = 8081)
 public class OrderServiceIntegrationTest {
     @Autowired private OrderService orderService;
     @Test
     void testProcessPaymentSuccess() {
         stubFor(post(urlEqualTo("/payments/process"))
                 .willReturn(aResponse().withStatus(200).withBody("{ \"status\": \"SUCCESS\" }")));
         Order order = new Order("Laptop", 999.99);
         String paymentStatus = orderService.processPayment(order);
         assertThat(paymentStatus).isEqualTo("SUCCESS");
     }
 }