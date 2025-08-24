import java.util.ArrayList;

public class TestVessels {
    public static void main(String[] args) {
        // Starting code for testing ships
        Ship genericShip = new Ship("The Wanderer", "Alice Smith", 15.0, 75);
        Tanker oilTanker = new Tanker("Ocean Giant", "Bob Johnson", 12.5, 90, "Crude Oil");
        ContainerShip maerskTripleE = new ContainerShip("Maersk Mc-Kinney Møller", "Charlie Brown", 20.0, 80, 18000);

        ArrayList<Ship> ships = new ArrayList<>();
        ships.add(genericShip);
        ships.add(oilTanker);
        ships.add(maerskTripleE);

        for (int i = 0; i < ships.size(); i++) {
            Ship ship = ships.get(i);
            ship.displayShipInfo();
        }
    }
}
