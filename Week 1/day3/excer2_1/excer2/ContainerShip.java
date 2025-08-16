public class ContainerShip extends Ship {
    private int numberOfTEU;

    public ContainerShip(String shipName, String captainName, double speedKnots, int fuelLevelPercentage, int numberOfTEU) {
        super(shipName, captainName, speedKnots, fuelLevelPercentage);
        this.numberOfTEU = numberOfTEU;
    }

    // getter method for numberOfTEU
    public int getNumberOfTEU() {
        return this.numberOfTEU;
    }

    // setter method for numberOfTEU
    public void setNumberOfTEU(int numberOfTEU) {
        this.numberOfTEU = numberOfTEU;
    }

    @Override
    public void displayShipInfo() {
        super.displayShipInfo();  // Call the parent method to display basic info
        System.out.println("Number of TEU: " + getNumberOfTEU());
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Number of TEU: " + getNumberOfTEU();
    }
}
