package com.group1.capstone.service;

import java.time.LocalDate;
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
    public Cargo getCargoById(int id) {
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
    public Cargo updateCargo(int id, Cargo updatedCargo) {
        return cargoRepository.findById(id).map(cargo -> {
            cargo.setName(updatedCargo.getName());
            cargo.setDescriptions(updatedCargo.getDescriptions());
            cargo.setStatusCode(updatedCargo.getStatusCode());
            cargo.setDestination(updatedCargo.getDestination());
            cargo.setOrigin(updatedCargo.getOrigin());
            cargo.setWeight(updatedCargo.getWeight());

            return cargoRepository.save(cargo);
        }).orElseThrow(() -> new CargoNotFoundException("Cargo with ID " + id + " not found."));
    }
    
    // 6. Delete cargo
    public void deleteCargo(int id) {
        if (!cargoRepository.existsById(id)) {
            throw new CargoNotFoundException("Cargo with ID " + id + " not found.");
        }
        cargoRepository.deleteById(id);
    }

    // 7. Get all cargo going to selected location for the day
    public List<Cargo> getCargoGoingToPortOnDate(String portCode, LocalDate date) {
        return cargoRepository.findCargoGoingToPortOnDate(portCode, date);
    }
    
    // 8. Get all cargo coming from selected location for the day
    public List<Cargo> getCargoComingFromPortOnDate(String portCode, LocalDate date) {
        return cargoRepository.findCargoComingFromPortOnDate(portCode, date);
    }
    
    // 9. Get all cargo moving for the day, month, year
    public List<Cargo> getCargoMovingOnDate(LocalDate date) {
        return cargoRepository.findCargoMovingOnDate(date);
    }
}
