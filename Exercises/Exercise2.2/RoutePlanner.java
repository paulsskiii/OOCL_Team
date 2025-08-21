import java.util.Arrays;
import java.util.List;

public class RoutePlanner {
    private List<String> validPorts = Arrays.asList("Manila", "Singapore", "Tokyo", "Busan", "Hong Kong");

    public void planRoute(String origin, String destination) throws PortNotRecognizedException {
        // Validation logic

        try {
            if((!validPorts.contains(origin)) || (!validPorts.contains(destination))){
                throw new PortNotRecognizedException("Port origin or destination is invalid.");
            }
        } catch (PortNotRecognizedException e) {
            System.out.println(e.getMessage());
        }
       
    }

    public static void main(String[] args) throws PortNotRecognizedException{
        RoutePlanner planner = new RoutePlanner();

        // Test cases
        planner.planRoute("Manila", "Singapore");
        planner.planRoute("Tokyo", "New York"); //false
        planner.planRoute("London", "Busan"); //false
        planner.planRoute("London", "New York"); //false
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