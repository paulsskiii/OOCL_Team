package com.example.cargoservice.component;

import org.springframework.stereotype.Component;

/**
 * Component to check the operational status of a port.
 */
@Component
public class PortAvailabilityChecker {

    public boolean isPortOperational(String portName) {
        // Basic logic: if portName equals "Damaged Port" (case-insensitive), return false
        if (portName.equalsIgnoreCase("Damaged Port")) {
            return false; 
        } 
        else
            return true;
    }
}