package Exercise_3_2;

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
        double averageMaxSpeed = ships.stream()
                .mapToDouble(Ship::getMaxSpeedKnot)
                .average()
                .orElse(0.0);

        System.out.println("Average Maximum Speed of all ships: " + averageMaxSpeed);


        // Test with an empty list
        List<Ship> emptyShips = new ArrayList<>();
        double emptyAverageMaxSpeed = emptyShips.stream()
                .mapToDouble(Ship::getMaxSpeedKnot)
                .average()
                .orElse(0.0);

        System.out.println("EMPTY - Average Maximum Speed of all ships: " + emptyAverageMaxSpeed);
    }
}
