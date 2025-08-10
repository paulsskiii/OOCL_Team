package com.example.cargoservice.repository;

import com.example.cargoservice.model.Ship;
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
        ships.add(new Ship("1", "Titanic", 50000, "Damaged Port"));
        ships.add(new Ship("2", "Queen Mary", 80000, "Long Beach"));
        ships.add(new Ship("3", "Oasis of the Seas", 60000, "Port Canaveral"));
        ships.add(new Ship("4", "Harmony of the Seas", 60000, "Barcelona"));
        ships.add(new Ship("5", "Symphony of the Seas", 60000, "Damaged Port"));
    }

    /**
     * Get all ships.
     * @return List of all ships.
     */
    public List<Ship> findAllShips() {
        // TODO: Return a copy of the ships list
        return new ArrayList<>(ships);
    }

    /**
     * Find a ship by ID.
     * @param id The ship ID to search for.
     * @return Optional of Ship if found.
     */
    public Optional<Ship> findShipById(Long id) {
        // TODO: Search through the list and return the first match
        return ships.stream()
                .filter(ship -> ship.getId().equals(id.toString()))
                .findFirst();
    }
}