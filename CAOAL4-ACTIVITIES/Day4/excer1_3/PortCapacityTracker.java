import java.util.HashMap;
import java.util.Map;

public class PortCapacityTracker {
    public static void main(String[] args) {
        Map<String, Port> ports = new HashMap<>();

        ports.put("Manila", new Port("Manila", 5, 3));
        ports.put("Singapore", new Port("Singapore", 7, 6));
        ports.put("Tokyo", new Port("Tokyo", 4, 4));

        // Simulation logic here
        ports.get("Manila").shipArrives();
        ports.get("Singapore").shipArrives();
//        ports.get("Tokyo").shipArrives();
        ports.get("Tokyo").shipDeparts();

        // Print current occupancy of all ports
        System.out.println("==========================");
        System.out.println("==Port Current Occupancy==");
        for (Port port : ports.values()) {
            System.out.println("Port: " + port.getName());
            System.out.println("Current Occupancy: " + port.getCurrentOccupancy() + "/" + port.getCapacity());
            System.out.println("---------------------");
        }

    }
}