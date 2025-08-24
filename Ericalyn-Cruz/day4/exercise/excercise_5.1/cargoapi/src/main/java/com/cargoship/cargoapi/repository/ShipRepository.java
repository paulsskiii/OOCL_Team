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
        // Add some dummy ship data
        ships.add(new Ship(1L, "Evergreen", 5000, "Manila"));
        ships.add(new Ship(2L, "Poseidon", 3000, "Singapore"));
        ships.add(new Ship(3L, "Neptune", 4000, "Tokyo"));
        ships.add(new Ship(4L, "Oceanic", 3500, "Busan"));
        ships.add(new Ship(5L, "Titan", 4500, "Hong Kong"));
    }

    /**
     * Get all ships.
     * @return List of all ships (copy to avoid external modification).
     */
    public List<Ship> findAllShips() {
        return new ArrayList<>(ships); // return a copy
    }

    /**
     * Find a ship by ID.
     * @param id The ship ID to search for.
     * @return Optional of Ship if found.
     */
    public Optional<Ship> findShipById(Long id) {
        return ships.stream()
                .filter(ship -> ship.getId().equals(id))
                .findFirst();
    }
}
