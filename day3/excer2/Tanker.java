public class Tanker extends Ship {
    private String cargoTypeCarried;

    public Tanker(String shipName, String captainName, double speedKnots, int fuelLevelPercentage, String cargoTypeCarried) {
        super(shipName, captainName, speedKnots, fuelLevelPercentage);
        this.cargoTypeCarried = cargoTypeCarried;
    }

    public String getCargoTypeCarried() {
        return cargoTypeCarried;
    }

    public void setCargoTypeCarried(String cargoTypeCarried) {
        this.cargoTypeCarried = cargoTypeCarried;
    }

    @Override
    public String displayShipInfo() {
        return "Tanker shipName=" + getShipName() + ", captainName=" + getCaptainName() + ", speedKnots=" + getSpeedKnots()
        + ", fuelLevelPercentage=" + getFuelLevelPercentage() + ", cargoTypeCarried =" + this.cargoTypeCarried;
    }
}
