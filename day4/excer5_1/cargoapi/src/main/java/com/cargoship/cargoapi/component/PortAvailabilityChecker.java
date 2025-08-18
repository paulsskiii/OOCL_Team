package com.cargoship.cargoapi.component;

import org.springframework.stereotype.Component;

/**
 * Component to check the operational status of a port.
 */
@Component
public class PortAvailabilityChecker {

    public boolean isPortOperational(String portName) {
        if (portName.equalsIgnoreCase("Damaged Port")) {
            return false;  // port is not operational
        }
        return true; // all other ports are operational
    }
}
