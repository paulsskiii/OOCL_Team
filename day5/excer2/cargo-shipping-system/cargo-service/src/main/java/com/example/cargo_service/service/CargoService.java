// Create CargoService.java (Service Layer)
    // This class will encapsulate the business logic and interact with the CargoRepository

// src/main/java/com/example/cargoservice/service/CargoService.java
package com.example.cargo_service.service;

import com.example.cargo_service.model.CargoItem;
import com.example.cargo_service.repository.CargoRepository; // Import CargoRepository
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Marks this class as a Spring Service component
public class CargoService {

    private final CargoRepository cargoRepository; // Inject CargoRepository

    // Constructor injection for dependency
  public CargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public List<CargoItem> getAllCargoItems() {
        return cargoRepository.findAll(); // Uses JpaRepository's findAll()
    }

    public Optional<CargoItem> getCargoItemById(Long id) {
        return cargoRepository.findById(id); // Uses JpaRepository's findById()
    }

    public CargoItem addCargoItem(CargoItem cargoItem) {
        return cargoRepository.save(cargoItem); // Uses JpaRepository's save() for create/update
    }

    // Example for update (will be elaborated in exercises)
    public CargoItem updateCargoItem(Long id, CargoItem updatedCargoItem) {
        return cargoRepository.findById(id)
                .map(existingCargo -> {
                    existingCargo.setName(updatedCargoItem.getName());
                    existingCargo.setWeight(updatedCargoItem.getWeight());
                    existingCargo.setOrigin(updatedCargoItem.getOrigin());
                    existingCargo.setDestination(updatedCargoItem.getDestination());
                    return cargoRepository.save(existingCargo);
                })
                .orElse(null); // Or throw an exception for not found
    }

    // Example for delete (will be elaborated in exercises)
    public void deleteCargoItem(Long id) {
        cargoRepository.deleteById(id); // Uses JpaRepository's deleteById()
    }
}
