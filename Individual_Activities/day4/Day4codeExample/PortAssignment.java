// Mapping Ship to Current Port (HashMap)

import java.util.HashMap;
import java.util.Map;

public class PortAssignment {
    public static void main(String[] args) {
        Map<String, String> shipCurrentPort = new HashMap<>();
        shipCurrentPort.put("Sea Serpent", "Port of Manila");
        shipCurrentPort.put("Ocean Drifter", "Port of Singapore");
        shipCurrentPort.put("Star Gazer", "Port of Tokyo");

        System.out.println("Ship Port Assignments:");
        for (Map.Entry<String, String> entry : shipCurrentPort.entrySet()) {
            System.out.println(entry.getKey() + " is at " + entry.getValue());
        }

        System.out.println("\nOcean Drifter is at: " + shipCurrentPort.get("Ocean Drifter"));

        shipCurrentPort.put("Sea Serpent", "Port of Busan"); // Update port
        System.out.println("Sea Serpent is now at: " + shipCurrentPort.get("Sea Serpent"));
    }
}
