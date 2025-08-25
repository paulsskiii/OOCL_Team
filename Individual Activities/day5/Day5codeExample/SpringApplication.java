import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// This annotation tells Spring to manage this class as a "bean."
// It's the equivalent of a microservice in our earlier example.
@Service
class CoffeeService {
    public void placeOrder(String coffeeType) {
        System.out.println("☕️ Spring CoffeeService: Placing order for a " + coffeeType + ".");
    }
}

// This class is our main component that needs a dependency.
@Component
class CoffeeOrderManager {

    // This is where Dependency Injection happens via annotation.
    // We're not creating a 'new CoffeeService()'. Instead, we're telling
    // Spring to find an instance of CoffeeService and "autowire" it here.
    @Autowired
    private CoffeeService coffeeService;

    public void processOrder(String coffeeType) {
        System.out.println("🛒 CoffeeOrderManager: Processing order.");
        this.coffeeService.placeOrder(coffeeType);
    }
}

// This is a simplified representation of the Spring Boot application class.
// In a real app, Spring would automatically handle the bean creation and injection.
public class SpringApplication {
    public static void main(String[] args) {
        System.out.println("--- Spring Application is starting up and managing beans ---");

        // The Spring IoC container handles the creation and injection automatically.
        // We simulate this by creating the beans and injecting them ourselves for this example.
        CoffeeService coffeeService = new CoffeeService();
        CoffeeOrderManager orderManager = new CoffeeOrderManager();
        orderManager.setCoffeeService(coffeeService); // This is a simple setter-based injection

        System.out.println("\n--- The Spring-managed components are ready ---");
        orderManager.processOrder("Latte");
    }
}

// NOTE: In a real Spring Boot application, you would not write the main method
// this way. Spring's framework takes care of creating the beans and wiring
// them together based on the @Component and @Autowired annotations.
// The code above is for illustrative purposes only to show the relationships.
