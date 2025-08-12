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
        ships.add(new Ship(1,"Name1",2,"Manila"));
        ships.add(new Ship(2,"Name2",2,"Tokyo"));
        ships.add(new Ship(3,"Name3",2,"Busan"));
        ships.add(new Ship(4,"Name4",2,"New York"));
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
        return ships.stream().filter( ship -> ship.getId() == id).findFirst();
    }
}