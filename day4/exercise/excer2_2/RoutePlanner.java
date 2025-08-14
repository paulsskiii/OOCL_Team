import java.util.Arrays;
import java.util.List;

public class RoutePlanner {
    private static List<String> validPorts = Arrays.asList("Manila", "Singapore", "Tokyo", "Busan", "Hong Kong");

    public static boolean planRoute(String origin, String destination) throws PortNotRecognizedException {
        // Validation logic
        // Checking of valid ports
        for (String port : validPorts) {
            if (port.equalsIgnoreCase(destination)) {
                return true;
            }
            if (port.equalsIgnoreCase(origin)) {
                return true;
            }
        }
        throw new PortNotRecognizedException("Port " + destination + " is not valid");
    }

    public static void main(String[] args) throws PortNotRecognizedException {
        RoutePlanner planner = new RoutePlanner();

        // Test cases

        try {
            // Test Case 1
            planRoute("Manila", "Singapore");
            // Test Case 2
            planRoute("Tokyo", "New York");
            // Test Case 3
            planRoute("London", "Busan");
            // Test Case 4
            planRoute("London", "New York");
        } catch (Exception e) {
            e.printStackTrace();
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