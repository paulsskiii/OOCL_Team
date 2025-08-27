package com.cargoship.cargo_api.component;

import com.cargoship.cargo_api.model.Ship;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PortAvailabilityChecker {

    public boolean isPortAvailable(Optional<Ship> foundShip){
        return foundShip.stream()
                .map(Ship::getCurrentPort)
                .equals("Manila");
    }


}
