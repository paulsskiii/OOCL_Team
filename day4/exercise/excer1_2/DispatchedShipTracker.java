import java.util.HashSet;
import java.util.Set;

public class DispatchedShipTracker {
    public static void main(String[] args) {
        String[] shipInputs = {"OOCL Ship", "TEMU Ship", "Shpispishpi", "Shipishipship", "OOCL Ship"};
        Set<String> dispatchedShips = new HashSet<>();
        int i;
        // Add ship names
        for (i = 0; i < shipInputs.length; i++)
            dispatchedShips.add (shipInputs[i]);

        // Check for ship presence
        System.out.println ("Is ship [OOCL Ship] in Set: " + dispatchedShips.contains ("OOCL Ship"));
        System.out.println ("Is ship [Jamba Ship] in Set: " + dispatchedShips.contains ("Jamba Ship"));

        System.out.println ("\nDispatched Ship Set: ");
        System.out.println (dispatchedShips);
    }
}