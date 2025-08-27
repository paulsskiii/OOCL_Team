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
        List<Ship> emptyShipsList = new ArrayList<>();

        // Calculate average max speed
        double averageMaxSpeed = ships.stream() 
                                    .mapToDouble(Ship::getMaxSpeedKnot)
                                    .average().orElse(0.0);
        
        // Test with an empty list
        double emptyAverage = emptyShipsList.stream() 
                                    .mapToDouble(Ship::getMaxSpeedKnot)
                                    .average().orElse(0.0);

        System.out.println("Average speed of Ship List: " + averageMaxSpeed 
                        + "\nAverage speed of Empty List: " + emptyAverage);
    }
}