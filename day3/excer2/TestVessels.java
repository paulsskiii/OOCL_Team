import java.util.ArrayList;
import java.util.List;

public class TestVessels {
    public static void main(String[] args) {
        // Starting code for testing ships
        Ship genericShip = new Ship("The Wanderer", "Alice Smith", 15.0, 75);
        Tanker oilTanker = new Tanker("Ocean Giant", "Bob Johnson", 12.5, 90, "Crude Oil");
        ContainerShip maerskTripleE = new ContainerShip("Maersk Mc-Kinney Møller", "Charlie Brown", 20.0, 80, 18000);

        List<Ship> shipments = new ArrayList<>(List.of(
                new Ship("The Wanderer", "Alice Smith", 15.0, 75),
                new Tanker("Ocean Giant", "Bob Johnson", 12.5, 90, "Crude Oil"),
                new ContainerShip("Maersk Mc-Kinney Møller", "Charlie Brown", 20.0, 80, 18000)
            )
        );

        for(Ship ship: shipments){
            System.out.println(ship.displayShipInfo());
        }
    }
}
