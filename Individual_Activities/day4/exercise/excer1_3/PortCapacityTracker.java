import java.util.HashMap;
import java.util.Map;

public class PortCapacityTracker {
    public static void main(String[] args) {
        Map<String, Port> ports = new HashMap<>();

        ports.put("Manila", new Port("Manila", 5, 3));
        ports.put("Singapore", new Port("Singapore", 7, 6));
        ports.put("Tokyo", new Port("Tokyo", 4, 4));

        // Simulation logic here
    }
}