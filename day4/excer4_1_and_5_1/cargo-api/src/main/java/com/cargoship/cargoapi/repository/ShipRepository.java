package com.cargoship.cargoapi.repository;

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
        int i = 0;
        ships.add (new Ship (i++, "OOCL", 30000.0, "MNL"));                     // 0
        ships.add (new Ship (i++, "OOLU", 20000.0, "JKT"));                     // 1
        ships.add (new Ship (i++, "shipishipship", 4000.0, "INC"));             // 2
        ships.add (new Ship (i++, "mishishippi", 50000.0, "VAN"));              // 3
        ships.add (new Ship (i++, "gold ship", 180000.0, "Damaged Port"));      // 4
    }

    /**
     * Get all ships.
     * @return List of all ships.
     */
    public List<Ship> findAllShips() {
        // TODO: Return a copy of the ships list
        return ships;
    }

    /**
     * Find a ship by ID.
     * @param id The ship ID to search for.
     * @return Optional of Ship if found.
     */
    public Optional<Ship> findShipById(Long id) {
        // TODO: Search through the list and return the first match
        for (Ship ship : ships)
            if (ship.getId () == id) return Optional.of(ship);
        
        return Optional.empty();
    }
}