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

        System.out.println("Average max speed is: " + calculateAverageMaxSpeed(ships));
        
        // Test with an empty list
        ships = new ArrayList<>();
        
        System.out.println("Average max speed is: " + calculateAverageMaxSpeed(ships));
       
    }
    
    // Calculate average max speed
    public static Double calculateAverageMaxSpeed(List<Ship> ships){
        return ships.stream()
        .mapToDouble(Ship::getMaxSpeedKnot)
        .average()
        .orElse(0);
    }
}
