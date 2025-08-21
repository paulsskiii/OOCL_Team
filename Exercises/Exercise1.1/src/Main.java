import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<CargoItem> itemList = new ArrayList<>();

        CargoItem cargoItem1 = new CargoItem(1, "cargo1", 100.0, "Philippines");
        CargoItem cargoItem2 = new CargoItem(2, "cargo2", 101.0, "America");
        CargoItem cargoItem3 = new CargoItem(3, "cargo3", 102.0, "Korea");
        CargoItem cargoItem4 = new CargoItem(4, "cargo4", 103.0, "Japan");
        CargoItem cargoItem5 = new CargoItem(5, "cargo5", 104.0, "Italy");

        itemList.add(cargoItem1);
        itemList.add(cargoItem2);
        itemList.add(cargoItem3);
        itemList.add(cargoItem4);
        itemList.add(cargoItem5);

        System.out.println("All Cargo Items:");
        for(CargoItem item : itemList) {
            System.out.println(item);
        }

        itemList.remove(itemList.get(3));
        System.out.println();

        System.out.println("Remaining Cargo Items:");
        for(CargoItem item : itemList) {
            System.out.println(item);
        }
    }
}