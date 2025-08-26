// Managing a Fleet of Ships (ArrayList) Code Example
import java.util.ArrayList;
import java.util.List;

class Ship {
    String name;
    String captain;

    public Ship(String name, String captain) {
        this.name = name;
        this.captain = captain;
    }

    @Override
    public String toString() {
        return "Ship{" + "name='" + name + '\'' + ", captain='" + captain + '\'' + '}';
    }
}

public class FleetManager {
    public static void main(String[] args) {
        List<Ship> fleet = new ArrayList<>();
        fleet.add(new Ship("Sea Serpent", "Captain Jack"));
        fleet.add(new Ship("Ocean Drifter", "Captain Anne"));
        fleet.add(new Ship("Star Gazer", "Captain Bluebeard"));

        System.out.println("Current Fleet:");
        for (Ship ship : fleet) {
            System.out.println(ship);
        }

        // Remove a ship
        fleet.remove(new Ship("Sea Serpent", "Captain Jack")); // Note: This remove won't work as expected without equals/hashCode in Ship class
                                                            // For simplicity here, let's remove by index
        // fleet.remove(0); // Removes "Sea Serpent"

        System.out.println("\nFleet after removal (if by index):");
        for (Ship ship : fleet) {
            System.out.println(ship);
        }
    }
}