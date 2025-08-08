// 1. The Dependency Interface: This defines the "what" but not the "how".
// It's like the blueprint for a coffee ordering system.
// Any class that wants to be a "CoffeeService" must implement this interface.
interface CoffeeService {
    void placeOrder(String coffeeType);
}

// 2. A Concrete Dependency Implementation: This is the actual "how".
// This class represents the mobile app, which implements the CoffeeService.
// This is a specific type of dependency that can be injected.
class MobileAppCoffeeService implements CoffeeService {
    @Override
    public void placeOrder(String coffeeType) {
        System.out.println("☕️ New order received from the mobile app.");
        System.out.println("  Processing order for a " + coffeeType + ".");
    }
}

// 3. The Dependent Class: This class needs a dependency to function.
// It's the core logic for placing an order, but it doesn't know *how* the order is placed.
// This is where Dependency Injection happens.
class CoffeeOrder {
    // This is the dependency. The CoffeeOrder class depends on a CoffeeService.
    private final CoffeeService coffeeService;

    // This is the **Dependency Injection** via the constructor.
    // The CoffeeService is "injected" into the CoffeeOrder from the outside.
    public CoffeeOrder(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    public void processOrder(String coffeeType) {
        System.out.println("\n--- The CoffeeOrder class is now executing ---");
        // The CoffeeOrder class simply uses its dependency without knowing how it works.
        this.coffeeService.placeOrder(coffeeType);
        System.out.println("--- Order processing finished ---");
    }
}

// 4. The "IoC Container" or Main Application: This is where the magic happens.
// The main method acts as our simple IoC container. It controls the creation
// of objects and "injects" the dependencies.
public class Main {
    public static void main(String[] args) {
        // This is the **Inversion of Control**.
        // The `main` method creates the dependency first.
        System.out.println("The main application is starting up.");
        CoffeeService mobileAppService = new MobileAppCoffeeService();

        // The `main` method then creates the `CoffeeOrder` object
        // and **injects** the `mobileAppService` dependency into it.
        // The `CoffeeOrder` class is no longer in control of its own dependencies.
        CoffeeOrder myOrder = new CoffeeOrder(mobileAppService);

        // Now, we can tell the `myOrder` object to do its work.
        // We just call the method; we don't have to worry about how the order gets placed.
        myOrder.processOrder("Latte");

        System.out.println("\n--- Demonstrating Flexibility ---");
        // We can easily swap out the dependency without changing the CoffeeOrder class.
        // Let's create a hypothetical counter service.
        CoffeeService counterService = new CoffeeService() {
            @Override
            public void placeOrder(String coffeeType) {
                System.out.println("📝 New order taken at the counter.");
                System.out.println("  Writing down the order for a " + coffeeType + ".");
            }
        };

        // We "inject" the new dependency into a new CoffeeOrder instance.
        CoffeeOrder secondOrder = new CoffeeOrder(counterService);
        secondOrder.processOrder("Espresso");
    }
}
