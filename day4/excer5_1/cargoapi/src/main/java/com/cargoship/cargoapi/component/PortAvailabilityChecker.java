package com.cargoship.cargoapi.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cargoship.cargoapi.service.ShipService;

/**
 * Component to check the operational status of a port.
 */
@Component
public class PortAvailabilityChecker {

    @Autowired
    private ShipService shipService;

    // @Autowired
    // public void setShipService(ShipService shipService) {
    //     this.shipService = shipService;
    // }

    public boolean isPortOperational(String portName) {
        // Basic logic: if portName equals "Damaged Port" (case-insensitive), return false
        this.shipService.samplePortOperation(portName);

        if("Damaged Port".equals(portName)) {
            System.out.println("Port is damaged!");
            return false;
        }

        System.out.println("Port is operttional!");
        return true; // replace with actual condition
    }
}
