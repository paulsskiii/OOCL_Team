package com.cargoship.cargo_api.service;

import com.cargoship.cargo_api.component.PortAvailabilityChecker;
import com.cargoship.cargo_api.model.Ship;
import com.cargoship.cargo_api.model.ShipRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipService {

    private final ShipRepository shipRepository;
    private final PortAvailabilityChecker portAvailabilityChecker;

    public ShipService(ShipRepository shipRepository, PortAvailabilityChecker portAvailabilityChecker) {
        this.shipRepository = shipRepository;
        this.portAvailabilityChecker = portAvailabilityChecker;
    }

    public List<Ship> getAllShips() {
        return shipRepository.findAllShips();
    }

    public Optional<Ship> getShipDetails(int id) {
        return shipRepository.findShipById(id);
    }

    public boolean ifPortAvailable(int id) {
        Optional<Ship> foundShip = shipRepository.findShipById(id);
        return portAvailabilityChecker.isPortAvailable(foundShip);
    }

}
