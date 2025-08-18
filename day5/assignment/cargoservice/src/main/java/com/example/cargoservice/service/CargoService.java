package com.example.cargoservice.service;

import com.example.cargoservice.exception.CargoNotFoundException;
import com.example.cargoservice.model.CargoItem;
import com.example.cargoservice.repository.CargoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService {

    private final CargoRepository cargoRepository;

    public CargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public List<CargoItem> getAllCargoItems() {
        return cargoRepository.findAll();
    }

    public Page<CargoItem> getAllCargoItems(Pageable pageable) {
        return cargoRepository.findAll(pageable);
    }

    public CargoItem getCargoItemById(Long id) {
        return cargoRepository.findById(id)
                .orElseThrow(() -> new CargoNotFoundException("Cargo item with ID " + id + " not found."));
    }

    public CargoItem addCargoItem(CargoItem cargoItem) {
        return cargoRepository.save(cargoItem);
    }

    public CargoItem updateCargoItem(Long id, CargoItem updatedCargoItem) {
        return cargoRepository.findById(id)
                .map(existingCargo -> {
                    existingCargo.setName(updatedCargoItem.getName());
                    existingCargo.setWeight(updatedCargoItem.getWeight());
                    existingCargo.setOrigin(updatedCargoItem.getOrigin());
                    existingCargo.setDestination(updatedCargoItem.getDestination());
                    return cargoRepository.save(existingCargo);
                })
                .orElseThrow(() -> new CargoNotFoundException("Cargo item with ID " + id + " not found for update."));
    }

    public void deleteCargoItem(Long id) {
        if (!cargoRepository.existsById(id)) {
            throw new CargoNotFoundException("Cargo item with ID " + id + " not found for deletion.");
        }
        cargoRepository.deleteById(id);
    }

    public List<CargoItem> searchCargoByOrigin(String origin) {
        return cargoRepository.findByOrigin(origin);
    }

    public List<CargoItem> searchCargoByDestination(String destination) {
        return cargoRepository.findByDestination(destination);
    }

    public List<CargoItem> searchCargoByWeightRange(double minWeight, double maxWeight) {
        return cargoRepository.findByWeightBetween(minWeight, maxWeight);
    }

    public List<CargoItem> searchCargoByOriginPattern(String originPattern) {
        return cargoRepository.findByOriginContaining(originPattern);
    }
}