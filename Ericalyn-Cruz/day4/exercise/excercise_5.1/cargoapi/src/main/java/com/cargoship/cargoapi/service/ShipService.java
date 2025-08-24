package com.cargoship.cargoapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cargoship.cargoapi.model.Ship;
import com.cargoship.cargoapi.repository.ShipRepository;

/**
 * Service class for Ship-related business logic.
 */
@Service
public class ShipService {

    private final ShipRepository shipRepository;

    // Constructor injection
    public ShipService(ShipRepository shipRepository) {
        this.shipRepository = shipRepository; // Initialize repository field
    }

    /**
     * Get all ships from the repository.
     */
    public List<Ship> getAllShips() {
        return shipRepository.findAllShips(); // Return all ships
    }

    /**
     * Get ship details by ID.
     */
    public Optional<Ship> getShipDetails(Long id) {
        return shipRepository.findShipById(id); // Find by ID
    }
}
