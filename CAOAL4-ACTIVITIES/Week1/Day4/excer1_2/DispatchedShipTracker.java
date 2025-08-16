import java.util.HashSet;
import java.util.Set;

public class DispatchedShipTracker {
    public static void main(String[] args) {
        Set<String> dispatchedShips = new HashSet<>();

        // Add ship names
        dispatchedShips.add("OOCLVessel1");
        dispatchedShips.add("OOCLVessel2");
        dispatchedShips.add("OOCLTitanic");
        dispatchedShips.add("OOCLVessel3");
        dispatchedShips.add("OOCLTitanic");

        // Check for ship presence
        String shipToCheck = "OOCLTitanic";
        if (dispatchedShips.contains(shipToCheck)) {
            System.out.println(shipToCheck + " has been dispatched.");
        } else {
            System.out.println(shipToCheck + " has not been dispatched yet.");
        }

        // Print all unique dispatched ships
        System.out.println("===========================");
        System.out.println("All unique dispatched ships:");
        for (String ship : dispatchedShips) {
            System.out.println(ship);
        }
    }
}
