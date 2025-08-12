import java.util.HashSet;
import java.util.Set;

public class DispatchedShipTracker {
    public static void main(String[] args) {
        Set<String> dispatchedShips = new HashSet<>();

        // Add ship names
        dispatchedShips.add("ABC Ship");
        dispatchedShips.add("ABC Ship");
        dispatchedShips.add("BCD Ship");
        dispatchedShips.add("123 Ship");
        dispatchedShips.add("CDB Ship");
        dispatchedShips.add("QWE Ship");
        
        System.out.println("Dispatched ships:" + dispatchedShips);
    }
}
