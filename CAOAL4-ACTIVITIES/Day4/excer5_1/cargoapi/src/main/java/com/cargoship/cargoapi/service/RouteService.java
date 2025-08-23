package com.cargoship.cargoapi.service;

import com.cargoship.cargoapi.component.PortAvailabilityChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    private final PortAvailabilityChecker portAvailabilityChecker;

    @Autowired
    public RouteService(PortAvailabilityChecker portAvailabilityChecker) {
        this.portAvailabilityChecker = portAvailabilityChecker;
    }

    public void dispatchShip(String portName) {
        if (portAvailabilityChecker.isPortOperational(portName)) {
            System.out.println("Ship dispatched to " + portName);
        } else {
            System.out.println("Ship cannot be dispatched. " + portName + " is not operational.");
        }
    }
}
