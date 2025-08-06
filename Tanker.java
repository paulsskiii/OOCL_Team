public class Tanker extends Ship {
    private String cargoTypeCarried;

    public Tanker(String cargoTypeCarried) {
        this.cargoTypeCarried = cargoTypeCarried;
    }

    public String getCargoTypeCarried() {
        return cargoTypeCarried;
    }

    public void setCargoTypeCarried(String cargoTypeCarried) {
        this.cargoTypeCarried = cargoTypeCarried;
    }

//    @Override
//    public void displayShipInfo() {
//        System.out.println("Cargo Type Carried: " + cargoTypeCarried);
//    }
}
