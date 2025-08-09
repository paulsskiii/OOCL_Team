import java.util.Arrays;
import java.util.List;

public class RoutePlanner {
    private List<String> validPorts = Arrays.asList("Manila", "Singapore", "Tokyo", "Busan", "Hong Kong");
    String origin;
    String destination;

    public void planRoute(String origin, String destination) throws PortNotRecognizedException {
        // Validation logic
        if(!validPorts.contains(origin) && !validPorts.contains(destination)) {
            throw new PortNotRecognizedException(origin + " and " + destination + " are not valid ports.");
        } else {
            if(!validPorts.contains(origin)) {
                throw new PortNotRecognizedException(origin + " is not a valid port.");
            }
            if(!validPorts.contains(destination)) {
                throw new PortNotRecognizedException(destination + " is not a valid port.");
            }
            System.out.println("Route is valid.");
        }

    }

    public static void main(String[] args) {
        RoutePlanner planner = new RoutePlanner();

        // Test cases
        try{
            planner.planRoute("Manila", "Busan");
        } catch(PortNotRecognizedException e) {
            System.err.println("Error occured. "+e.getMessage());
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