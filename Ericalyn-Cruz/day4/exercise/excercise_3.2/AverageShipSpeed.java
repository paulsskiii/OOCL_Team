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

        OptionalDouble averageSpeed = ships.stream()
                                           .mapToDouble(Ship::getMaxSpeedKnot)
                                           .average();

        if (averageSpeed.isPresent()) {
            System.out.println("Average Max Speed: " + averageSpeed.getAsDouble() + " knots");
        } else {
            System.out.println("No ships available.");
        }
    }
}
