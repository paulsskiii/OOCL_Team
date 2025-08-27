package day15.test.testing.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    public ResponseEntity<Order> createCustomer(@RequestBody Order order) {
        Order newOrder = orderService.createOrder(order);
        return new ResponseEntity<>(newOrder, HttpStatus.OK);
    }

    @PostMapping("/payments/process")
    public ResponseEntity<String> processPayment(@RequestBody Order order) {
        orderService.processPayment(order);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
