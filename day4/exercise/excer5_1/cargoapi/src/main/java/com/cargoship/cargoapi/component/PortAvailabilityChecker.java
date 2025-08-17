package com.cargoship.cargoapi.component;

import org.springframework.stereotype.Component;

import com.cargoship.cargoapi.service.ShipService;

/**
 * Component to check the operational status of a port.
 */
@Component
public class PortAvailabilityChecker {
    private static final String DAMAGED_PORT = "Damaged Port";

    if (portName.equalsIgnoreCase(DAMAGED_PORT)) {
        return false;
    }
    return true;
}
