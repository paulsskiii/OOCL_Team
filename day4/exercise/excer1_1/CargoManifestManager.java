package exer1_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CargoManifestManager {
    
    public static void main (String[] args){
        List<CargoItem> cargoItemList = new ArrayList<>();
        List<CargoItem> item = new ArrayList<>();

        Scanner scan = new Scanner(System.in);

        cargoItemList.add(new CargoItem(100, "Gundam Plastic Model", 12.00, "Manila"));
        cargoItemList.add(new CargoItem(200, "Lithium Batteries", 20.00, "Manila"));
        cargoItemList.add(new CargoItem(300, "Plastic Plates", 12.00, "Manila"));
        cargoItemList.add(new CargoItem(400, "Denim Pants", 17.00, "Manila"));
        cargoItemList.add(new CargoItem(500, "Books", 12.00, "Manila"));

        System.out.println("Current Item List" + cargoItemList);

        System.out.println("Enter id to remove: ");
        long indexToRemove = scan.nextLong();
        
        for (CargoItem cargoItem : cargoItemList){
            if (indexToRemove == cargoItem.getId()) {
                continue;
            }
            item.add(cargoItem);
        }
    
        System.out.println("New cargo list: " + item);
    }
}
