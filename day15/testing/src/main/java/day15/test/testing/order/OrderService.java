package day15.test.testing.order;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

     public Order createOrder(Order order){
          return order;
     }

     public String processPayment(Order order){
          return "SUCCESS";
     }
}
