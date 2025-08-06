public class Tanker extends Ship {
    
    private String cargoTypeCarrierId;

    public Tanker(String shipName, String captainName, double speedKnots, int fuelLevelPercentage, String cargoTypeCarrierId){
        super(shipName, captainName, speedKnots, fuelLevelPercentage);
        this.cargoTypeCarrierId;
    }

    @Override
    void displayShipInfo(){
        System.out.println("Cargo Type Carrier ID: " + cargoTypeCarrierId)
    }

}
