import java.util.HashSet;
import java.util.Set;

public class DispatchedShipTracker {
    public static void main(String[] args) {
        Set<String> dispatchedShips = new HashSet<>();

        // Add ship names
        
        dispatchedShips.add("Alpha");
        dispatchedShips.add("Bravo");
        dispatchedShips.add("Charlie");
        dispatchedShips.add("Alpha");

        for (String dispatchedShip : dispatchedShips) {
            System.out.println(dispatchedShip);
        }

        // Check for ship presence

        if(dispatchedShips.contains("Alpha")){
            System.out.println("Alpha exists");
        }

        for (String dispatchedShip : dispatchedShips) {
            if (dispatchedShip.contains("Alpha")){
                System.out.println(dispatchedShip);
            }
        }
    }
}
