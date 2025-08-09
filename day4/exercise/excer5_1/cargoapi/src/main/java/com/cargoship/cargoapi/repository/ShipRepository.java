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
        this.ships.add(new Ship(100, "Ship", 100, "Manila"));
        this.ships.add(new Ship(200, "Shaep", 120, "damaged port"));
        this.ships.add(new Ship(300, "Sheep", 200, "London"));
        this.ships.add(new Ship(400, "Shyp", 220, "Damaged Port"));
        this.ships.add(new Ship(500, "Ship 2", 400, "Tokyo"));
    }

    /**
     * Get all ships.
     * @return List of all ships.
     */
    public List<Ship> findAllShips() {
        // TODO: Return a copy of the ships list
        return this.ships;
    }

    /**
     * Find a ship by ID.
     * @param id The ship ID to search for.
     * @return Optional of Ship if found.
     */
    public Optional<Ship> findShipById(Long id) {
        // TODO: Search through the list and return the first match
        return this.ships.stream()
                .filter(x -> x.getId() == id)
                .findFirst();
    }
}