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
        //  Add some dummy ship data to the list
        ships.add(new Ship(1, "Ling", 2, "Mnl"));
        ships.add(new Ship(2, "Gang", 4, "Mnl"));
        ships.add(new Ship(3, "Guli", 6, "Mnl"));
        ships.add(new Ship(4, "Guli", 8, "Mnl"));
        ships.add(new Ship(5, "Wata", 10, "Mnl"));
    }

    /**
     * Get all ships.
     * @return List of all ships.
     */
    public List<Ship> findAllShips() {
        //  Return a copy of the ships list
        return null;
    }

    /**
     * Find a ship by ID.
     * @param id The ship ID to search for.
     * @return Optional of Ship if found.
     */
    public Optional<Ship> findShipById(Long id) {
        //  Search through the list and return the first match
        return Optional.empty();
    }
}