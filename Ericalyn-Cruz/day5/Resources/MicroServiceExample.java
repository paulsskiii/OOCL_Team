import java.util.UUID;
import java.util.Random;

// A simple data object to represent an order.
class Order {
    private final String orderId;
    private final String item;
    private final int quantity;

    public Order(String item, int quantity) {
        this.orderId = UUID.randomUUID().toString();
        this.item = item;
        this.quantity = quantity;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
}

// 1. The Inventory Service: Manages stock levels.
// This is a "microservice" responsible only for inventory-related business logic.
class InventoryService {
    private static final Random random = new Random();

    public boolean checkStock(String item, int quantity) {
        System.out.println("📦 InventoryService: Checking stock for " + quantity + " of " + item + ".");
        // Simulate a database lookup. Assume stock is available 90% of the time.
        boolean stockAvailable = random.nextInt(10) < 9;
        if (stockAvailable) {
            System.out.println("  Stock is available.");
        } else {
            System.out.println("  Stock is not available.");
        }
        return stockAvailable;
    }
}

// 2. The Order Service: Creates and processes orders.
// This service uses the InventoryService as a dependency.
class OrderService {
    private final InventoryService inventoryService;

    // Dependency Injection: The InventoryService is injected here.
    public OrderService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public String createOrder(String item, int quantity) {
        System.out.println("🛒 OrderService: Attempting to create an order for " + quantity + " of " + item + ".");
        
        // This service relies on another service to do its job.
        // In a real-world scenario, this would be a network call (e.g., a REST API call).
        boolean stockAvailable = inventoryService.checkStock(item, quantity);

        if (stockAvailable) {
            Order newOrder = new Order(item, quantity);
            System.out.println("  ✅ Order created with ID: " + newOrder.getOrderId());
            return newOrder.getOrderId();
        } else {
            System.out.println("  ❌ Order failed: Insufficient stock.");
            return null;
        }
    }
}

// 3. The Notification Service: Sends confirmations.
// This service is independent and only focuses on sending messages.
class NotificationService {
    public void sendConfirmation(String orderId) {
        System.out.println("📧 NotificationService: Sending confirmation for order ID " + orderId + ".");
        // In a real application, this would send an email or a push notification.
        System.out.println("  Confirmation message sent successfully.");
    }

    public void sendFailureNotice() {
        System.out.println("📧 NotificationService: Sending a failure notice to the customer.");
        System.out.println("  Notice sent.");
    }
}

// 4. The Main Application/API Gateway: Orchestrates the services.
// This class represents the entry point for a user request. It uses all the services
// to fulfill a complete user task (placing an order).
public class MicroServiceExample {
    public static void main(String[] args) {
        System.out.println("--- Starting up the application's services ---");

        // The "API Gateway" or main application creates the instances of our services.
        InventoryService inventoryService = new InventoryService();
        NotificationService notificationService = new NotificationService();
        // The OrderService requires the InventoryService to be created and injected.
        OrderService orderService = new OrderService(inventoryService);

        System.out.println("\n--- Processing a user's request: Order a Latte ---");
        String latteOrderId = orderService.createOrder("Latte", 2);

        if (latteOrderId != null) {
            notificationService.sendConfirmation(latteOrderId);
        } else {
            notificationService.sendFailureNotice();
        }

        System.out.println("\n--- Processing a user's request: Order a Pizza ---");
        // This second request might fail due to our simulated random stock check.
        String pizzaOrderId = orderService.createOrder("Pizza", 1);
        if (pizzaOrderId != null) {
            notificationService.sendConfirmation(pizzaOrderId);
        } else {
            notificationService.sendFailureNotice();
        }
    }
}
