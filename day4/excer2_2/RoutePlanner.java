import java.util.Arrays;
import java.util.List;

public class RoutePlanner {
    private List<String> validPorts = Arrays.asList("Manila", "Singapore", "Tokyo", "Busan", "Hong Kong");

    public void planRoute(String origin, String destination) throws PortNotRecognizedException {
        if (!validPorts.contains (origin))
            throw new PortNotRecognizedException ("Origin port not recognized. Received: " + origin);

        if (!validPorts.contains (destination))
            throw new PortNotRecognizedException ("Destination port not recognized. Received: " + destination);
    }

    public static void main(String[] args) {
        RoutePlanner planner = new RoutePlanner();
        String[] originInputs = {"Manila", "Tokyo", "London", "London"};
        String[] destinationInputs = {"Singapore", "New York", "Busan", "New York"};
        
        // Test cases

        for (int i = 0; i < originInputs.length; i++) {
            try {
                System.out.println ("Planning route for origin: " + originInputs[i] + " | destination: " + destinationInputs[i]);
                planner.planRoute (originInputs[i], destinationInputs[i]);
                System.out.println ("Route successfully planned.");
            } catch (PortNotRecognizedException e) {
                System.out.println (e.getMessage ());
            } finally {
                System.out.println ("Now in finally. Please review message above.\n");
            }
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