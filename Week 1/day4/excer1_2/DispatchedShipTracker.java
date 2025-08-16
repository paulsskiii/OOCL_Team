import java.util.HashSet;
import java.util.Set;

public class DispatchedShipTracker {
    public static void main(String[] args) {
        Set<String> dispatchedShips = new HashSet<>();

        // Add ship names
        dispatchedShips.add("Ship1");
        dispatchedShips.add("Ship2");
        dispatchedShips.add("Ship3");
        dispatchedShips.add("Ship4");
        dispatchedShips.add("Ship5");

        // Check for ship presence
        String ship = "Ship3";
        if (dispatchedShips.contains(ship)) {
            System.out.println(ship + " has been dispatched.");
        } else {
            System.out.println(ship + " has not been dispatched");
        }
    }
}
