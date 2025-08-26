// Simulating Port Not Found (Custom Exception) Code Example
// Custom Exception Class
class PortNotFoundException extends Exception {
    public PortNotFoundException(String message) {
        super(message);
    }
}

public class PortRegistry {
    private String[] availablePorts = {"Manila", "Singapore", "Tokyo"};

    public boolean isPortAvailable(String portName) throws PortNotFoundException {
        for (String port : availablePorts) {
            if (port.equalsIgnoreCase(portName)) {
                return true;
            }
        }
        throw new PortNotFoundException("Port '" + portName + "' is not found in the registry.");
    }

    public static void main(String[] args) {
        PortRegistry registry = new PortRegistry();
        try {
            if (registry.isPortAvailable("Manila")) {
                System.out.println("Manila is available.");
            }
            if (registry.isPortAvailable("London")) { // This will throw an exception
                System.out.println("London is available.");
            }
        } catch (PortNotFoundException e) {
            System.err.println("Error checking port availability: " + e.getMessage());
        }
    }
}
