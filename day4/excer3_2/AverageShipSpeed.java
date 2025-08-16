package excer3_2;

import java.util.Arrays;
import java.util.Collections;
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
        System.out.println("Average Ship Speed: ");
        ships.stream()
                .mapToDouble(Ship::getMaxSpeedKnot)
                .average().ifPresent(System.out::println);

        // Test with an empty list
        System.out.println("Average Ship Speed of empty list: ");
        List<Ship> emptyShipList = Collections.emptyList();
        Double result = emptyShipList.stream()
                .mapToDouble(Ship::getMaxSpeedKnot)
                .average()
                .orElse(0.0);

        System.out.println(result);
    }
}
