import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class AverageShipSpeed {
    public static void main(String[] args) {
        List<Ship> ships = Arrays.asList(
            new Ship("Sea Serpent", 25.5),
            new Ship("Ocean Drifter", 22.0),
            new Ship("Star Gazer", 18.0),
            new Ship("Pacific Pearl", 30.0)
        );

        // Calculate average max speed
        
        double averageShipSpeed = ships.stream()
                                           .mapToDouble(ship -> ship.getMaxSpeedKnot())
                                           .average()
                                           .orElse(0.0);

        System.out.println("The average ship speed of the ships is " + averageShipSpeed);                                   
        // Test with an empty list
       
    }
}
