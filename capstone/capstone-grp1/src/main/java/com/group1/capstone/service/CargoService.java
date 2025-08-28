package com.group1.capstone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group1.capstone.exceptions.CargoNotFoundException;
import com.group1.capstone.model.Cargo;
import com.group1.capstone.repository.CargoRepository;

@Service
public class CargoService {
    @Autowired
    private CargoRepository cargoRepository;

    // 1. Find all cargos
    public List<Cargo> getAllCargos() {
        return cargoRepository.findAll();
    }

    // 2. Find cargo by ID
    public Cargo getCargoById(Long id) {
        return cargoRepository.findById(id)
                .orElseThrow(() -> new CargoNotFoundException("Cargo with ID " + id + " not found."));
    }

    // 3. Get cargo count
    public long getCargoCount() {
        return cargoRepository.count();
    }

    // 4. Add cargo
    public Cargo addCargo(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    // 5. Update cargo    
    public Cargo updateCargo(Long id, Cargo updatedCargo) {
        return cargoRepository.findById(id).map(cargo -> {
            // CHANGE nalang naten to depende sa kung ano mga columns sa model class naten
            cargo.setName(updatedCargo.getName());
            cargo.setDescriptions(updatedCargo.getDescriptions());
            cargo.setStatus(updatedCargo.getStatus());
            cargo.setDestination(updatedCargo.getDestination());
            cargo.setOrigin(updatedCargo.getOrigin());
            cargo.setWeight(updatedCargo.getWeight());
            cargo.setUpdatedAt(updatedCargo.getUpdatedAt());

            return cargoRepository.save(cargo);
        }).orElseThrow(() -> new CargoNotFoundException("Cargo with ID " + id + " not found."));
    }
    
    // 6. Delete cargo
    public void deleteCargo(Long id) {
        if (!cargoRepository.existsById(id)) {
            throw new CargoNotFoundException("Cargo with ID " + id + " not found.");
        }
        cargoRepository.deleteById(id);
    }
}
