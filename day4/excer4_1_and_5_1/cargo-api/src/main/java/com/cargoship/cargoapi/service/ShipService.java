package com.cargoship.cargoapi.service;

import com.cargoship.cargoapi.component.PortAvailabilityChecker;
import com.cargoship.cargoapi.model.Ship;
import com.cargoship.cargoapi.repository.ShipRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.sound.sampled.Port;

/**
 * Service class for Ship-related business logic.
 */
@Service
public class ShipService {

    @Autowired
    private final ShipRepository shipRepository;

    @Autowired
    private PortAvailabilityChecker portAvailabilityChecker = new PortAvailabilityChecker();

    public ShipService(ShipRepository shipRepository) {
        // TODO: Initialize the repository field
        this.shipRepository = shipRepository; // Replace
    }

    /**
     * Get all ships from the repository.
     */
    public List<Ship> getAllShips() {
        return shipRepository.findAllShips ();
    }

    /**
     * Get ship details by ID.
     */
    public Optional<Ship> getShipDetails (Long id) {
        Ship ship = shipRepository.findShipById (id).get ();

        if (portAvailabilityChecker.isPortOperational (ship.getCurrentPort ()))
            return Optional.of (ship);
        else return Optional.empty ();
    }
}