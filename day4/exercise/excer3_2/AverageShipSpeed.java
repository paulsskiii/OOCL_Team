import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AverageShipSpeed {
    public static void main(String[] args) {
        List<Ship> ships = Arrays.asList(
            new Ship("Sea Serpent", 25.5),
            new Ship("Ocean Drifter", 22.0),
            new Ship("Star Gazer", 18.0),
            new Ship("Pacific Pearl", 30.0)
        );

        // Calculate average max speed
        System.out.println("Average Ship Speed from Populated List:" + ships.stream().mapToDouble(ship -> ship.getMaxSpeedKnot()).average().orElse(0.0));
        
        // Test with an empty list
        List<Ship> emptyListOfShips = new ArrayList<>();

        System.out.println("Average Ship Speed from Empty List: " + emptyListOfShips.stream().mapToDouble(ship -> ship.getMaxSpeedKnot()).average().orElse(0.0));

       
    }
}