package com.cargoship.cargoapi.component;

import org.springframework.stereotype.Component;

/**
 * Component to check the operational status of a port.
 */
@Component
public class PortAvailabilityChecker {

    public PortAvailabilityChecker () {}

    public boolean isPortOperational(String portName) {
        String damageString = "Damaged Port";

        damageString = damageString.toLowerCase ();
        portName = portName.toLowerCase ();

        // Basic logic: if portName equals "Damaged Port" (case-insensitive), return false
        return !(portName.equals (damageString)); // replace with actual condition
    }
}
