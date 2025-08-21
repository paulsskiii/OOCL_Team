package com.cargoship.cargoapi.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.cargoship.cargoapi.model.Ship;

/**
 * In-memory repository for managing Ship data.
 */
@Repository
public class ShipRepository {

    // In-memory ship list
    private final List<Ship> ships = new ArrayList<>();

    public ShipRepository() {
        // TODO: Add some dummy ship data to the list
        ships.add(new Ship(1, "ship1", 40, "Philippines"));
        ships.add(new Ship(2, "ship2", 45, "Hong Kong"));
        ships.add(new Ship(3, "ship3", 50, "China"));
        ships.add(new Ship(4, "ship4", 55, "Japan"));
        ships.add(new Ship(5, "ship5", 60, "Singapore"));
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

        /*Ship shipById = ships.stream()
        .filter(ship -> ship.getId() == id)
        .findFirst();
        */
        return Optional.empty();
    }

}