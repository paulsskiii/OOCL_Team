import java.util.ArrayList;
import java.util.List;

public class TestVessels {
    public static void main(String[] args) {
        // Starting code for testing ships
        List<Ship> ship =  new ArrayList<Ship>();

        Ship genericShip = new Ship("The Wanderer", "Alice Smith", 15.0, 75);
        Tanker oilTanker = new Tanker("Ocean Giant", "Bob Johnson", 12.5, 90, "Crude Oil");
        ContainerShip maerskTripleE = new ContainerShip("Maersk Mc-Kinney Møller", "Charlie Brown", 20.0, 80, 18000);

        ship.add(genericShip);
        ship.add(oilTanker);
        ship.add(maerskTripleE);

        for(Ship ship1 : ship) {
            ship1.displayShipInfo();
        }
    }
}
