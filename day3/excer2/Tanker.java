public class Tanker extends Ship {
    private String cargoTypeCarried;

    public Tanker(String shipName, String captainName, double speedKnots, int fuelLevelPercentage, String cargoTypeCarried) {
        super(shipName, captainName, speedKnots, fuelLevelPercentage);
        this.cargoTypeCarried = cargoTypeCarried;
    }

    @Override
    public void displayShipInfo(){
        super.displayShipInfo();
        System.out.println("Cargo Type Carried: " + cargoTypeCarried);
    }
}
