public class Main {
    public static void main (String[] args){
        Cargo cargo = new Cargo();

        cargo.setCargoType("Electronics");
        cargo.setTrackingNumber("TRK4073839050");
        cargo.setCurrentLocation("Port of Manila");
        cargo.setEstimatedDeliveryDays(3);
        cargo.setDelivered(false);
        cargo.setWeight(1500.75);

        checkEstimatedDeliveryDays(cargo);
    }

    public static String checkEstimatedDeliveryDays(Cargo cargo) {
        if (cargo.getEstimatedDeliveryDays() <= 3){
            return "Express delivery! Expected in " + cargo.getEstimatedDeliveryDays() + " days.";
        } else if (cargo.getEstimatedDeliveryDays() <= 7 && cargo.getEstimatedDeliveryDays() >= 4) {
            return "Standard delivery. Expected in 4 - 7 days";
        } 
        return "Long haul delivery. Expected in X days.";
    }
}
