import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PortCapacityTracker {
    public static void main(String[] args) {
        Map<String, Port> ports = new HashMap<>();

        ports.put("Manila", new Port("Manila", 5, 3));
        ports.put("Singapore", new Port("Singapore", 7, 6));
        ports.put("Tokyo", new Port("Tokyo", 4, 4));

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of port:");
        String name = sc.nextLine();
        Port selectedPort = ports.get(name);

        if (selectedPort != null) {
            if (selectedPort.currentOccupancy >= selectedPort.capacity) {
                System.out.println("Failed! Current occupancy of " + selectedPort.getName() + " port is at or over its max capacity of " + selectedPort.capacity);
            } else {
                System.out.println("Success! Current occupancy of " + selectedPort.getName() + " port is less than its max capacity of " + selectedPort.capacity);
            }
        } else {
            System.out.println("Port not found: " + name);
        }
    }
}