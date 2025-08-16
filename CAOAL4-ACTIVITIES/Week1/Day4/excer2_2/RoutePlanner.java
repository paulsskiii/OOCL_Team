import java.util.Arrays;
import java.util.List;

public class RoutePlanner {
    private List<String> validPorts = Arrays.asList("Manila", "Singapore", "Tokyo", "Busan", "Hong Kong");

    public void planRoute(String origin, String destination) throws PortNotRecognizedException {
        // Validation logic

        if (!validPorts.contains(origin) || !validPorts.contains(destination)){
            throw new PortNotRecognizedException("Port Not Valid");
        } else {
            System.out.println("The Origin or Destination ports are VALID.");
        }
    }

    public static void main(String[] args) {
        RoutePlanner planner = new RoutePlanner();

        // Test Case 1
        // String origin = "Manila";
        // String destination = "Singapore";

        // Test Case 2
        String origin = "Tokyo";
        String destination = "New York";

        // Test Case 3
        // String origin = "London";
        // String destination = "Busan";

        // Test Case 4
        // String origin = "London";
        // String destination = "New York";

        try {
            planner.planRoute(origin, destination);
        } catch (PortNotRecognizedException e) {
            System.out.println("Origin: " + origin + " Destination: " + destination);
            System.out.println("The Origin or Destination ports are invalid");
        }

    }
}




// // test case

// // Test Case 1
// origin = "Manila";
// destination = "Singapore";

// // Test Case 2
// origin = "Tokyo";
// destination = "New York";

// // Test Case 3
// origin = "London";
// destination = "Busan";

// // Test Case 4
// origin = "London";
// destination = "New York";