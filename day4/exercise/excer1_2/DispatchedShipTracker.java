import java.util.HashSet;
import java.util.Set;

public class DispatchedShipTracker {
    public static void main(String[] args) {
        Set<String> dispatchedShips = new HashSet<>();
        
        // Add dispatched ship names
        dispatchedShips.add("Ship 1");
        dispatchedShips.add("Ship 2");
        dispatchedShips.add("Ship 3");
        dispatchedShips.add("Ship 4");
        dispatchedShips.add("Ship 5");
        
        System.out.println("Dispatched ships added");

        // Add ship names
        dispatchedShips.add("Ship a");
        dispatchedShips.add("Ship b");
        dispatchedShips.add("Ship 3");

        // Check for ship presence
        System.out.println(dispatchedShips.stream().anyMatch(shipName -> shipName.equalsIgnoreCase("Ship 1")) ? "Ship 1 was dispatched" : "Ship 1 was not dispatched");


        System.out.println(dispatchedShips);
    }
}