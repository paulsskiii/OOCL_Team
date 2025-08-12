package com.ooclteam.coffee;
import org.springframework.stereotype.Service;

// This annotation tells Spring to manage this class as a "bean."
// It's the equivalent of a microservice in our earlier example.
@Service
class CoffeeService {
    public void placeOrder(String coffeeType) {
        System.out.println("☕️ Spring CoffeeService: Placing order for a " + coffeeType + ".");
    }
}
