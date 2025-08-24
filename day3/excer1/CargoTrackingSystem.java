package day3.excer1;

public class CargoTrackingSystem {
    public static void main(String[] args){
        Cargo cargo = new Cargo(0, "box", 60009238L, "Manila", 5, true, 1.65f);
        System.out.println(cargo.checkEstimatedDays());
    }
}
