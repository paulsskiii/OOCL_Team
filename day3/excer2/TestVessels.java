import java.util.ArrayList;

public class TestVessels {
    public static void main(String[] args) {
        ArrayList<Ship> ships = new ArrayList<>();
        ships.add(new Ship("Voyager", "Captain Smith", 20.5, 80));
        ships.add(new Tanker("Ocean Giant", "Captain Lee", 15.0, 60, "Oil"));
        ships.add(new ContainerShip("Cargo King", "Captain Kim", 18.0, 75, 500));

        for (Ship ship : ships) {
            ship.displayShipInfo();
            System.out.println("-----");
        }
    }
} 