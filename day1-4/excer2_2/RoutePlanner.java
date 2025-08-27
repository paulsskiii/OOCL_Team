package excer2_2;

import java.util.Arrays;
import java.util.List;

public class RoutePlanner {
    private List<String> validPorts = Arrays.asList("Manila", "Singapore", "Tokyo", "Busan", "Hong Kong");

    public void planRoute(String origin, String destination) throws PortNotRecognizedException {
        // Validation logic
        if (validPorts.contains(origin) && validPorts.contains(destination)) {
            System.out.println("Route from " + origin + " to " + destination + " is planned.");
        } else {
            throw new PortNotRecognizedException("Ports are not recognized!");
        }
    }

    public static void main(String[] args) {
        RoutePlanner planner = new RoutePlanner();

        // Test cases
        try {
            planner.planRoute("Manila", "Singapore");   // Happy Case
            planner.planRoute("Tokyo", "New York");     // Invalid destination
            planner.planRoute("London", "Busan");       // Invalid origin
            planner.planRoute("London", "New York");    // Invalid origin & destination
        } catch (PortNotRecognizedException e) {
            System.out.println(e.getMessage());
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