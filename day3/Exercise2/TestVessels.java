package Exercise2;
import Java34.OOCL_Team.Exercise2.ShipWorker;

public class TestVessels {

    public static void main(String[] args) {

        ShipWorker[] ships = new ShipWorker[2];

        // Add instances to the array
        ships[0] = new ContainerShip("Downtown", "name", 1.01, 50, 21);
        ships[1] = new Tanker("Downtown", "name", 1.01, 50, "carrierID");

        for (ShipWorker ship : ships) {
            ship.displayShipInfo();
        }

    }
}
