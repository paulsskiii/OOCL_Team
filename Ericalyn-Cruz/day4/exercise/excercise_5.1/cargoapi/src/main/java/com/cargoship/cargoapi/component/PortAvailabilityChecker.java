package com.cargoship.cargoapi.component;

import org.springframework.stereotype.Component;

@Component
public class PortAvailabilityChecker {

    public boolean isPortOperational(String portName) {
        if (portName == null) {
            return false;
        }
        // Return false if the port is "Damaged Port" (case-insensitive), true otherwise
        return !portName.equalsIgnoreCase("Damaged Port");
    }
}
