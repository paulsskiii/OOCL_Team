package excer3_2;

import java.util.Arrays;
import java.util.Collections;
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
        double ave = getAve(ships);
        System.out.println("Max speed" + ave);

        // Test with an empty list
        List<Ship> emptyShips = Collections.emptyList();
        double emptyAve = getAve(emptyShips);
        System.out.println("Average max speed of empty list): " + emptyAve);
    }

    private static double getAve(List<Ship> ships) {
        return ships.stream()
                .mapToDouble(value -> value.maxSpeedKnot)
                .average()
                .orElse(0.0);
    }
}
