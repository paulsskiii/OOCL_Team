package com.cargoship.cargoapi.service;

import com.cargoship.cargoapi.model.Ship;
import com.cargoship.cargoapi.repository.ShipRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for Ship-related business logic.
 */
@Service
public class ShipService {

    @Autowired
    private final ShipRepository shipRepository;

    public ShipService(ShipRepository shipRepository) {
        //  Initialize the repository field
        this.shipRepository = null; // Replace
    }

    /**
     * Get all ships from the repository.
     */
    public List<Ship> getAllShips() {
        //  Call repository to return all ships

        return null;
    }

    /**
     * Get ship details by ID.
     */
    public Optional<Ship> getShipDetails(Long id) {
        //  Call repository to find a ship by ID
        return Optional.empty();
    }
}