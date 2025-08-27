import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DispatchedShipTracker {
    public static void main(String[] args) {
        Set<String> dispatchedShips = new HashSet<>();

        // Add ship names
        dispatchedShips.add("Ship A");
        dispatchedShips.add("Ship B");
        dispatchedShips.add("Ship B");
        dispatchedShips.add("Ship C");

        // Check for ship presence
        Scanner input = new Scanner(System.in);
        System.out.print("Input a vessel name to check if dispatched: ");
        String vesselName = input.nextLine();
        input.close();

        System.out.println("Is " + vesselName + " dispatched? " + dispatchedShips.contains(vesselName));

        System.out.println("===== List of Dispatched Ships: =====");
        for (String dispatchedShip : dispatchedShips) {
            System.out.println(dispatchedShip);
        }
    }
}