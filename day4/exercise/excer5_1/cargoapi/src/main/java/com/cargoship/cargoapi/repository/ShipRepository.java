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
        ships.add(new Ship(101L, "Ship 1", 123.32, "Port 1"));
        ships.add(new Ship(102L, "Ship 2", 3210.43, "Port 2"));
        ships.add(new Ship(103L, "Ship 3", 543400.54, "Port 3"));
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
        return ships.stream()
            .filter(s -> id.equals(s.getId()))
            .findFirst();
    }
}