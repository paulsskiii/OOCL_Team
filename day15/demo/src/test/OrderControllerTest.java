
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.MediaType;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.when;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.test.web.servlet.MockMvc;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// import com.example.demo.controller.OrderController;
// import com.example.demo.model.Order;
// import com.example.demo.service.OrderService;
// import static com.github.tomakehurst.wiremock.client.WireMock.post;

// // --- OrderControllerTest.java (@WebMvcTest) ---
// @WebMvcTest(OrderController.class)
// public class OrderControllerTest {
//     @Autowired private MockMvc mockMvc;
//     @MockBean private OrderService orderService;
//     @Test
//     void testCreateOrder() throws Exception {
//         when(orderService.createOrder(any(Order.class))).thenReturn(new Order(1L, "Laptop", 999.99, "CONFIRMED"));
//         mockMvc.perform(post("/orders").contentType(MediaType.APPLICATION_JSON).content("..."))
//                .andExpect(status().isOk());
//     }
// }
