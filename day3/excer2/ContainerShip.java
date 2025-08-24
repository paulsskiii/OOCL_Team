public class ContainerShip extends Ship {
    private int numberOfTEU;

    public ContainerShip(String shipName, String captainName, double speedKnots, int fuelLevelPercentage,
            int numberOfTEU) {
        super(shipName, captainName, speedKnots, fuelLevelPercentage);
        this.numberOfTEU = numberOfTEU;
    }

    @Override
    public void displayShipInfo() {
        super.displayShipInfo();
        System.out.println(numberOfTEU);
    }

}
