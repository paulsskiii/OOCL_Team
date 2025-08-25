import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Port {
    String name;
    int maxCapacity; // maximum ships
    int currentOccupancy;
    List<String> currentShips;

    public Port(String name, int maxCapacity, String... currentShips) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        // this.currentOccupancy = currentOccupancy;
        this.currentShips = new ArrayList<>(Arrays.asList(currentShips));
        this.currentOccupancy = currentShips.length;
    }

    // Getters and add/remove ship methods
    public String getName() {
        return this.name;
    }

    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    public int getCurrentOccupancy() {
        return this.currentOccupancy;
    }

    public List<String> getCurrentShips() {
        return this.currentShips;
    }

    public void addShip(String shipName) {
        if(maxCapacity != currentShips.size()) {
            currentShips.add(shipName);
            System.out.println("Ship added!");
        } else {
            System.out.println("Max capacity reached!");
        }
            System.out.println(currentShips);

    }

    public void removeShip(String shipName) {
        if(currentShips.size() != 0) {
            currentShips.removeIf(ship -> shipName.equals(ship));
            System.out.println("Ship removed!");
        } else {
            System.out.println("Port is not occupied!");
        }
            System.out.println(currentShips);
    }
}