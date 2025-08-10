public class Tanker extends Ship { //ShipRepository
    private String cargoTypeCarried;

    public Tanker(String shipName, String captainName, double speedKnots, int fuelLevelPercentage, String cargoTypeCarried) {
        super(shipName, captainName, speedKnots, fuelLevelPercentage);
        this.cargoTypeCarried = cargoTypeCarried;
    }

    @Override
    public String displayShipInfo(){
        return String.format("Ship Name: %s, Captain Name: %s, Speed Knots: %f, Fuel Level Percentage: %d, Cargo Type Carried: %s!%n", 
        this.shipName,this.captainName, this.speedKnots, this.fuelLevelPercentage, cargoTypeCarried);
    }
}
