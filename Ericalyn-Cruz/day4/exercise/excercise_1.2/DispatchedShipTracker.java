import java.util.HashSet;
import java.util.Set;

public class DispatchedShipTracker {
    public static void main(String[] args) {
        Set<String> dispatchedShips = new HashSet<>();

        // Add ship names
        dispatchedShips.add("Voyager");
        dispatchedShips.add("Ocean Giant");
        dispatchedShips.add("Maersk Mc-Kinney Møller");

        // Display all dispatched ships
        System.out.println("Dispatched Ships:");
        for (String ship : dispatchedShips) {
            System.out.println("- " + ship);
        }

        // Check for ship presence
        String shipToCheck = "Voyager";
        if (dispatchedShips.contains(shipToCheck)) {
            System.out.println(shipToCheck + " has been dispatched.");
        } else {
            System.out.println(shipToCheck + " is not dispatched yet.");
        }
    }
}
