import java.util.ArrayList;
import java.util.List;

public class ShipRepository {
    private List<Ship> ships;

    public ShipRepository() {
        ships = new ArrayList<>();
    }

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public List<Ship> getAllShips() {
        return ships;
    }
}
