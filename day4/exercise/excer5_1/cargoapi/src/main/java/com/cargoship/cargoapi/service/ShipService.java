package com.cargoship.cargoapi.service;

import com.cargoship.cargoapi.component.PortAvailabilityChecker;
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

    private final PortAvailabilityChecker portAvailabilityChecker = new PortAvailabilityChecker();

    public ShipService(ShipRepository shipRepository) {
        // TODO: Initialize the repository field
        this.shipRepository = shipRepository; // Replace
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
    public void checkPortAvailability(String port) {
        if(portAvailabilityChecker.isPortOperational(port)){
            System.out.printf("Port %s is available.\n", port);
        }else{
            System.out.println("Port " + port + " is not available.");
        }
    }
}