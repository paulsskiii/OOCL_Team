import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DispatchedShipTracker {
    public static void main(String[] args) {
        Set<String> dispatchedShips = new HashSet<>();

        // Add ship names
        dispatchedShips.add("OOCL");
        dispatchedShips.add("MAERSK");
        dispatchedShips.add("KIMI");
        dispatchedShips.add("PIERRE");
        dispatchedShips.add("BEARMAN");
        dispatchedShips.add("MAERSK");

        // Check for ship presence
        Scanner scan = new Scanner(System.in);

        for (String ship : dispatchedShips) {
            System.out.println(ship);
        }

        System.out.print("Please Enter ship name: ");
        String shipName = scan.nextLine();
        scan.close();

        dispatchedShips.stream()
        .filter(ship -> ship.equalsIgnoreCase(shipName))
        .findFirst()
        .ifPresentOrElse(ship -> System.out.println(ship + " has been dispatched"),
            () ->  System.out.println(shipName + " has not been dispatched"));

    }
}
