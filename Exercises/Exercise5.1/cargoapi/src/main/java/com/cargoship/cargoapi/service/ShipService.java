package com.cargoship.cargoapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cargoship.cargoapi.component.PortAvailabilityChecker;
import com.cargoship.cargoapi.model.Ship;
import com.cargoship.cargoapi.repository.ShipRepository;

/**
 * Service class for Ship-related business logic.
 */
@Service
public class ShipService {

    private final ShipRepository shipRepository;
    private final PortAvailabilityChecker portAvailabilityChecker;

    @Autowired
    public ShipService(ShipRepository shipRepository, PortAvailabilityChecker portAvailabilityChecker) {
        // TODO: Initialize the repository field
        this.shipRepository = shipRepository; // Replace
        this.portAvailabilityChecker = portAvailabilityChecker;
    }
    

    /**
     * Get all ships from the repository.
     */
    public List<Ship> getAllShips() {
        // TODO: Call repository to return all ships
        return shipRepository.findAllShips();
    }

    /**
     * Get ship details by ID.
     */
    public Optional<Ship> getShipDetails(Long id) {
        // TODO: Call repository to find a ship by ID
        return shipRepository.findShipById(id);
    }
}