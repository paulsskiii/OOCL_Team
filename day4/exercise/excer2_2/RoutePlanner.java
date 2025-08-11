import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class RoutePlanner {
    private List<String> validPorts = List.of("Manila", "Singapore", "Tokyo", "Busan", "Hong Kong");

    public void planRoute(String origin, String destination) throws PortNotRecognizedException {
        // Validation logic

        //origin and destination matches inside the list

        if(!validPorts.contains(origin) || !validPorts.contains(destination)){
            throw new PortNotRecognizedException("You must pick a valid origin or destination!");
        }
    }

    public static void main(String[] args) {
        RoutePlanner planner = new RoutePlanner();

        // TEST CASES
        
        // Test Case 1 - no errors
        // origin = "Manila";
        // destination = "Singapore";
        try {
            planner.planRoute("Manila", "Singapore");
        } catch (PortNotRecognizedException e) {
            System.out.println(e);
        } catch (Exception e){
            System.out.println(e);
        }finally{
            System.out.println("Done");
        }

        //  Test Case 2 - destination is not valid
        // origin = "Tokyo";
        // destination = "New York";
        try {
            planner.planRoute("Tokyo", "New York");
        } catch (PortNotRecognizedException e) {
            System.out.println(e);
        } catch (Exception e){
            System.out.println(e);
        } finally{
            System.out.println("Done");
        }

        // Test Case 3 - origin is not valid
        // origin = "London";
        // destination = "Busan";
        try {
            planner.planRoute("London", "Busan");
        } catch (PortNotRecognizedException e) {
            System.out.println(e);
        } catch (Exception e){
            System.out.println(e);
        } finally{
            System.out.println("Done");
        }

        
        // Test Case 4 - origin and destination is not valid
        // origin = "London";
        // destination = "New York";
        try {
            planner.planRoute("London", "New York");
        } catch (PortNotRecognizedException e) {
            System.out.println(e);
        } catch (Exception e){
            System.out.println(e);
        } finally{
            System.out.println("Done");
        }

    }
}

