package com.cargoship.cargoapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Autowired
    private final ShipRepository shipRepository;

    @Autowired
    private final PortAvailabilityChecker portAvailabilityChecker;

    public ShipService(ShipRepository shipRepository, PortAvailabilityChecker portAvailabilityChecker) {
        // TODO: Initialize the repository field
        this.shipRepository = shipRepository;
        this.portAvailabilityChecker = portAvailabilityChecker;
    }

    /**
     * Get all ships from the repository.
     */
    public List<Ship> getAllShips() {
        // TODO: Call repository to return all ships
        return shipRepository.findAllShips().stream()
                .filter(
                    ship -> portAvailabilityChecker
                            .isPortOperational(ship.getCurrentPort())
                ).collect(Collectors.toList());
    }

    /**
     * Get ship details by ID.
     */
    public Optional<Ship> getShipDetails(Long id) {
        // TODO: Call repository to find a ship by ID
        return shipRepository.findShipById(id);
    }
}