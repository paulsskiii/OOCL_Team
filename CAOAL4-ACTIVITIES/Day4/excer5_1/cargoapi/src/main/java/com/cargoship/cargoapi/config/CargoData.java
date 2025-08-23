package com.cargoship.cargoapi.config;

import com.cargoship.cargoapi.model.CargoItem;
import com.cargoship.cargoapi.repository.CargoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CargoData implements CommandLineRunner {

    private final CargoRepository cargoRepository;

    // Constructor injection
    public CargoData(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Only seed if the table is empty (prevents duplicate inserts)
        if (cargoRepository.count() == 0) {
            cargoRepository.save(new CargoItem(null, "Electronics", 150.0, "Manila", "Cebu"));
            cargoRepository.save(new CargoItem(null, "Apparel", 50.5, "Davao", "Manila"));
            cargoRepository.save(new CargoItem(null, "Perishables", 200.0, "Cebu", "Manila"));
            System.out.println("✅ Cargo data added!");
        } else {
            System.out.println("✅ Cargo data already exists.");
        }
    }
}
