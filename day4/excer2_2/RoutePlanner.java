package Exercise_2_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoutePlanner {
    private List<String> validPorts = Arrays.asList("Manila", "Singapore", "Tokyo", "Busan", "Hong Kong");

    public void planRoute(String origin, String destination) throws PortNotRecognizedException {
        try {
            List<String> invalidPorts = new ArrayList<>();

            if (!validPorts.contains(origin)) {invalidPorts.add(origin);}
            if (!validPorts.contains(destination)) {invalidPorts.add(destination);}

            if (invalidPorts.isEmpty()) {
                System.out.println("Your route: origin - " + origin + ", destination - " + destination + " is valid.");
            } else {
                throw new PortNotRecognizedException("Please enter a valid port. " + invalidPorts + " is invalid.");
            }
        } catch (PortNotRecognizedException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws PortNotRecognizedException {
        RoutePlanner planner = new RoutePlanner();

        // Test cases
        planner.planRoute("Manila", "Singapore"); // Test Case 1
        planner.planRoute("Tokyo", "New York"); // Test Case 2
        planner.planRoute("London", "Busan"); // Test Case 3
        planner.planRoute("London", "New York"); // Test Case 4
    }
}
