public class ContainerShip extends Ship {
    private int numberOfTEU;

    public ContainerShip(String shipName, String captainName, double speedKnots, int fuelLevelPercentage, int numberOfTEU) {
        super(shipName, captainName, speedKnots, fuelLevelPercentage);
        this.numberOfTEU = numberOfTEU;
    }

    public int getNumberOfTEU() {
        return numberOfTEU;
    }

    public void setNumberOfTEU(int numberOfTEU) {
        this.numberOfTEU = numberOfTEU;
    }

    @Override
    public String displayShipInfo() {
        return "Tanker shipName=" + getShipName() + ", captainName=" + getCaptainName() + ", speedKnots=" + getSpeedKnots()
        + ", fuelLevelPercentage=" + getFuelLevelPercentage() + ", numberOfTEU =" + this.numberOfTEU;
    }
}
