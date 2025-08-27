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
        double averageSpeed = ships.stream()
                .mapToDouble(Ship::getMaxSpeedKnot)
                .average()
                .orElse(0.0);

        System.out.println("Average maximum ship speed: " + averageSpeed + " knots");
    }
}