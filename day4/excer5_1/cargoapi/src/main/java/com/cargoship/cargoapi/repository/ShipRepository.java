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
        ships.add(new Ship(1, "HK Ship", 100, "HK"));
        ships.add(new Ship(2, "SG Ship", 100, "SG"));
        ships.add(new Ship(3, "TKY Ship", 100, "TKY"));
        ships.add(new Ship(4, "PH Ship", 100, "PH"));
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
    // public Ship findShipById(Long id) {
    //     // TODO: Search through the list and return the first match

    //     for(Ship ship : ships){
    //         if(ship.getId() == id){
    //             return ship;
    //         }
    //     } 
    //     return null;
    // }

    public Optional<Ship> findShipById(Long id) {
        // TODO: Search through the list and return the first match

        return ships.stream().filter(ship -> ship.getId() == id).findFirst();
    }
}