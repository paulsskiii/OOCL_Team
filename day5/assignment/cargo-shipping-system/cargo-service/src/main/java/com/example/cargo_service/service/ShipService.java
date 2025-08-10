package com.example.cargoservice.service;

import com.example.cargoservice.component.PortAvailabilityChecker;
import com.example.cargoservice.model.Ship;
import com.example.cargoservice.repository.ShipRepository;

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
    private final PortAvailabilityChecker portAvailabilityChecker;

    public ShipService(ShipRepository shipRepository, PortAvailabilityChecker portAvailabilityChecker) {
        // TODO: Initialize the repository field
        this.shipRepository = shipRepository; // Replace
        this.portAvailabilityChecker = portAvailabilityChecker;
    }

    /**
     * Get all ships from the repository.
     */
    public List<Ship> getAllShips() {
        // TODO: Call repository to return all ships only if the port is operational
        if (portAvailabilityChecker.isPortOperational("Damaged Port") == false) {
            return shipRepository.findAllShips();
        } else {
            return null;
        }
    }

    /**
     * Get ship details by ID.
     */
    public Optional<Ship> getShipDetails(Long id) {
        // TODO: Call repository to find a ship by ID only if the port is operational
        if (portAvailabilityChecker.isPortOperational("Damaged Port") == false) {
            return shipRepository.findShipById(id);
        } else {
            return Optional.empty();
        }
    }
}