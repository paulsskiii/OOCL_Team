import java.util.Arrays;
import java.util.List;

public class RoutePlanner {
    private List<String> validPorts = Arrays.asList("Manila", "Singapore", "Tokyo", "Busan", "Hong Kong");

    public void planRoute(String origin, String destination) throws PortNotRecognizedException {
        Boolean isOriginValid = validPorts.stream()
        .anyMatch(city -> city.equalsIgnoreCase(origin));

        Boolean isDestinationValid= validPorts.stream()
        .anyMatch(city -> city.equalsIgnoreCase(destination));

         if(isOriginValid && isDestinationValid){
            System.out.println("Ports " + origin + " and " + destination + " are valid");
         }
         else{
            throw new PortNotRecognizedException("Port is not valid");
         }
    }

    public static void main(String[] args) {
        RoutePlanner planner = new RoutePlanner();

        // Test cases
        try{
            planner.planRoute("Manila", "Singapore");
            planner.planRoute("Tokyo", "New York");
            planner.planRoute("London", "Busan");
            planner.planRoute("London", "New York");
        }catch(PortNotRecognizedException e){
            System.err.println(e);
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