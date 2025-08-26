// --- OrderControllerTest.java (@WebMvcTest) ---
@WebMvcTest(OrderController.class)
public class OrderControllerTest {
    @Autowired private MockMvc mockMvc;
    @MockBean private OrderService orderService;
    @Test
    void testCreateOrder() throws Exception {
        when(orderService.createOrder(any(Order.class))).thenReturn(new Order(1L, "Laptop", 999.99, "CONFIRMED"));
        mockMvc.perform(post("/orders").contentType(MediaType.APPLICATION_JSON).content("..."))
               .andExpect(status().isOk());
    }
}
