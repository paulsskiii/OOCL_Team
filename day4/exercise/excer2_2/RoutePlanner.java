package exer2_1;

import java.util.Arrays;
import java.util.List;

public class RoutePlanner {
    private List<String> validPorts = Arrays.asList("Manila", "Singapore", "Tokyo", "Busan", "Hong Kong");

    public void planRoute(String origin, String destination) throws PortNotRecognizedException {
        // Validation logic
        
        if (!validPorts.contains(origin))
            throw new PortNotRecognizedException("Port " + origin + " is invalid!");
        else if (!validPorts.contains(destination)) 
            throw new PortNotRecognizedException("Port " + destination + " is invalid!");
        else
            System.out.println("Both ports are valid!");
    }

    public static void main(String[] args) {
        RoutePlanner planner = new RoutePlanner();

        // Test cases
        try {
            planner.planRoute("Manila", "Singapore");
            planner.planRoute("Tokyo", "New York");
            planner.planRoute("London", "Busan");
            planner.planRoute("London", "New York");
        } catch (PortNotRecognizedException e) {
            e.getMessage();
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