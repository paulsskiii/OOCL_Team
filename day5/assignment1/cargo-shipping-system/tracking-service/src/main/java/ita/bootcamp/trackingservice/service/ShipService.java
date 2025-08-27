package ita.bootcamp.trackingservice.service;

import ita.bootcamp.trackingservice.component.PortAvailabilityChecker;
import ita.bootcamp.trackingservice.model.Ship;
import ita.bootcamp.trackingservice.model.ShipRepository;
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
