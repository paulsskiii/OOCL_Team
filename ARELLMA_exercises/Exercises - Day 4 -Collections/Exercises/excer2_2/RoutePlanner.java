import java.util.Arrays;
import java.util.List;

public class RoutePlanner {
    private List<String> validPorts = Arrays.asList("Manila", "Singapore", "Tokyo", "Busan", "Hong Kong");

    public void planRoute(String origin, String destination) throws PortNotRecognizedException {
        // Validation logic
        if(!validPorts.contains(origin) || !validPorts.contains(destination)){
            throw new PortNotRecognizedException("Port is not recognized");
        }
        else{
            System.out.println("Port found");
        }
    }

    public static void main(String[] args) throws PortNotRecognizedException {
        RoutePlanner planner = new RoutePlanner();

        // Test cases

        // Test Case 1
        // origin = "Manila";
        // destination = "Singapore";
        try{
            planner.planRoute("Manila", "Singapore");
        }
        catch(PortNotRecognizedException e){
            e.printStackTrace();
        }
        // Test Case 2
        // origin = "Tokyo";
        // destination = "New York";
        try{
            planner.planRoute("Tokyo", "New York");
        }
        catch(PortNotRecognizedException e){
            e.printStackTrace();
        }

        // Test Case 3
        // origin = "London";
        // destination = "Busan";
        try{
            planner.planRoute("London", "Busan");
        }
        catch(PortNotRecognizedException e){
            e.printStackTrace();
        } 

        // Test Case 4
        // origin = "London";
        // destination = "New York";
        try{
            planner.planRoute("London", "New York");
        }
        catch(PortNotRecognizedException e){
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