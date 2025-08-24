import java.util.Arrays;
import java.util.List;

// Custom exception
class PortNotRecognizedException extends Exception {
    public PortNotRecognizedException(String message) {
        super(message);
    }
}

public class RoutePlanner {
    private List<String> validPorts = Arrays.asList("Manila", "Singapore", "Tokyo", "Busan", "Hong Kong");

    public void planRoute(String origin, String destination) throws PortNotRecognizedException {
        if (!validPorts.contains(origin)) {
            throw new PortNotRecognizedException("Origin port not recognized: " + origin);
        }
        if (!validPorts.contains(destination)) {
            throw new PortNotRecognizedException("Destination port not recognized: " + destination);
        }

        System.out.println("Route planned: " + origin + " -> " + destination);
    }

    public static void main(String[] args) {
        RoutePlanner planner = new RoutePlanner();

        // Test cases
        String[][] testCases = {
                {"Manila", "Singapore"},
                {"Tokyo", "New York"},
                {"London", "Busan"},
                {"London", "New York"}
        };

        for (int i = 0; i < testCases.length; i++) {
            String origin = testCases[i][0];
            String destination = testCases[i][1];
            System.out.println("\nTest Case " + (i + 1) + ": " + origin + " -> " + destination);
            try {
                planner.planRoute(origin, destination);
            } catch (PortNotRecognizedException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
