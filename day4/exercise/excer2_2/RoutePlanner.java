import java.util.Arrays;
import java.util.List;

public class RoutePlanner {
    private List<String> validPorts = Arrays.asList("Manila", "Singapore", "Tokyo", "Busan", "Hong Kong");

    public void planRoute(String origin, String destination) throws PortNotRecognizedException {
        if (validPorts.contains(origin) && validPorts.contains(destination)) {
            System.out.println("Valid ports");
        } else {
            throw new PortNotRecognizedException("Port/s not recognized");
        }
    }

    public static void main(String[] args) {
        RoutePlanner planner = new RoutePlanner();
        try {
            System.out.println("Test Case 1 ");
            planner.planRoute("Manila", "Singapore");
        } catch (PortNotRecognizedException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println();
        }

        try {
            System.out.println("Test Case 2");
            planner.planRoute("Tokyo", "New York");
        } catch (PortNotRecognizedException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println();
        }

        try {
            System.out.println("Test Case 3");
            planner.planRoute("London", "Busan");
        } catch (PortNotRecognizedException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println();
        }

        try {
            System.out.println("Test Case 4");
            planner.planRoute("London", "New York");
        } catch (PortNotRecognizedException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println();
        }
    }
}