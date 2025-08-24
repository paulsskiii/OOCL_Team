import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DispatchedShipTracker {
    public static void main(String[] args) {
        Set<String> dispatchedShips = new HashSet<>();

        // Add ship names
        dispatchedShips.add("A");
        dispatchedShips.add("B");
        dispatchedShips.add("C");

        // Check for ship presence
        System.out.println("Which ship you want to dispatch?");
        Scanner scanner = new Scanner(System.in);
        String shipToCheck = scanner.nextLine();

        if (dispatchedShips.contains(shipToCheck)) {
            System.out.println(shipToCheck + " is existing.");
        } else {
            System.out.println("Ship " + shipToCheck + " is not existing");
        }

    }
}
