public class Tanker extends Ship {
    private String cargoTypeCarried;

    public Tanker(String shipName, String captainName, double speedKnots, int fuelLevelPercentage, String cargoTypeCarried) {
        super(shipName, captainName, speedKnots, fuelLevelPercentage);
        this.cargoTypeCarried = cargoTypeCarried;
    }

    // getter method for cargoTypeCarried
    public String getCargoType() {
        return this.cargoTypeCarried;
    }

    // setter method for cargoTypeCarried
    public void setCargoType(String cargoTypeCarried) {
        this.cargoTypeCarried = cargoTypeCarried;
    }

    @Override
    public void displayShipInfo() {
        super.displayShipInfo();  // Call the parent method to display basic info
        System.out.println("Cargo Type: " + getCargoType());
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + 
               "Cargo Type: " + getCargoType();
    }
}
