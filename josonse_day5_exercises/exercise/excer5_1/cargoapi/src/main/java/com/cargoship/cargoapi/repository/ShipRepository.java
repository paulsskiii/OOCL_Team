import com.cargoship.cargoapi.model.Ship;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * In-memory repository for managing Ship data.
 */
@Repository
public class ShipRepository {

    // In-memory ship list
    private final List<Ship> ships = new ArrayList<>();

    public ShipRepository() {
        // TODO: Add some dummy ship data to the list
        ships.add(new Ship(1, "ship1", 150, "Manila"));
        ships.add(new Ship(2, "ship2", 20, "Manila"));
        ships.add(new Ship(3, "ship3", 120, "Manila"));
        ships.add(new Ship(4, "ship4", 40, "Manila"));
        ships.add(new Ship(5, "ship5", 85, "Manila"));
    }

    /**
     * Get all ships.
     * @return List of all ships.
     */
    public List<Ship> findAllShips() {
        // TODO: Return a copy of the ships list
       
        List<Ship> findall = ships.stream()
                .collect(Collectors.toList());

        return findall;
//        return null;
        // for (Ship ship : ships){
        //     System.out.println(ship.toString());
        // }
    }

    /**
     * Find a ship by ID.
     * @param id The ship ID to search for.
     * @return Optional of Ship if found.
     */
    public Optional<Ship> findShipById(Long id) {
        // TODO: Search through the list and return the first match

        for (Ship ship : ships){
            if (ship.getId() == id){
                return Optional.of(ship);
            }
        }
        // List<Ship> getID = ships.stream()
        //     .filter(ship -> ship.getId() == id)
        //     .collect(Collectors.toList());
        
        // ships.getId(id);
        // ships.get
        return Optional.empty();
    }
}