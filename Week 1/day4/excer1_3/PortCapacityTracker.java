import java.util.HashMap;
import java.util.Map;

public class PortCapacityTracker {
    public static void main(String[] args) {
        Map<String, Port> ports = new HashMap<>();

        ports.put("Manila", new Port("Manila", 5, 3));
        ports.put("Singapore", new Port("Singapore", 7, 6));
        ports.put("Tokyo", new Port("Tokyo", 4, 4));

        // Simulation logic here
        Port manila = ports.get("Manila");

        // Try adding ships
        System.out.println("=== Manila Port Simulation ===");
        manila.addShip();
        manila.addShip();
        manila.addShip(); // This one should fail because capacity is reached

        // Try removing ships
        manila.removeShip();
        manila.removeShip();

        // Check status
        System.out.println("Final Occupancy at " + manila.getName() + ": " + manila.getCurrentOccupancy());
    }
}