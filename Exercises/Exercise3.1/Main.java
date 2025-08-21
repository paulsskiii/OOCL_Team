import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //HIGH-VALUE CARGO FILTERING
        System.out.println("HIGH-VALUE CARGO FILTERING:");
        List<CargoItem> itemList = new ArrayList<>();

        itemList.add(new CargoItem(1, "cargo1", 4000));
        itemList.add(new CargoItem(2, "cargo2", 50000));
        itemList.add(new CargoItem(3, "cargo3", 35000));
        itemList.add(new CargoItem(4, "cargo4", 5000));

        itemList = itemList.stream()
                .filter(cargoItem -> cargoItem.getValue() > 10000)
                .collect(Collectors.toList());

        for(CargoItem item : itemList){
            System.out.println(item);
        }

        //AVERAGE SHIP SPEED
        System.out.println();
        System.out.println("AVERAGE SHIP SPEED:");
        List<Ship> shipList = new ArrayList<>();

        shipList.add(new Ship("ship1", 5));
        shipList.add(new Ship("ship2", 10));
        shipList.add(new Ship("ship3", 15));
        shipList.add(new Ship("ship4", 20));

        double averageShipSpeed = shipList.stream()
                .mapToDouble(ship -> ship.getMaxSpeedKnot())
                .average()
                .orElse(0.0);

        System.out.println(averageShipSpeed);

        //UNIQUE PORT LIST
        System.out.println();
        System.out.println("AVERAGE SHIP SPEED:");

        List<String> cargoRoutes = new ArrayList<>();

        cargoRoutes.add("Manila -> Singapore");
        cargoRoutes.add("Manila -> Hong Kong");
        cargoRoutes.add("Manila -> Hong Kong");
        cargoRoutes.add("Japan -> Tokyo");
        cargoRoutes.add("Singapore -> China");

        cargoRoutes = cargoRoutes.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        for(String route : cargoRoutes){
            System.out.println(route);
        }

    }
}