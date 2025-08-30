package com.group1.capstone.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.group1.capstone.exceptions.CargoNotFoundException;
import com.group1.capstone.model.Cargo;
import com.group1.capstone.repository.CargoRepository;

@Service
public class CargoService {
    @Autowired
    private ProducerService producerService;

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
        producerService.sendMessage(cargo, "CREATED");
        return cargoRepository.save(cargo);
    }

    // 5. Update cargo    
    public Cargo updateCargo(int id, Cargo updatedCargo) {
        producerService.sendMessage(updatedCargo, "UPDATED ");
        return cargoRepository.findById(id).map(cargo -> {
            cargo.setName(updatedCargo.getName());
            cargo.setDescriptions(updatedCargo.getDescriptions());
            cargo.setStatusId(updatedCargo.getStatusId());
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
        producerService.sendMessage(getCargoById(id), "CREATED");
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
    public List<Cargo> getCargoMovingOnDate(LocalDate from, LocalDate to) {
        return cargoRepository.findCargoMovingOnDate(from, to);
    }

    // 10. Search by Cargo Name
    public List<Cargo> searchByCargoName(String name) {
        return cargoRepository.findByNameContainingIgnoreCase(name);
    }
    
    // 11. Filter by Status
    public List<Cargo> filterByStatus(int statusId) {
        return cargoRepository.findByStatusId(statusId);
    }
    
    // 12. Sort by Alphabetical (Ascending)
    public List<Cargo> sortByAlphabeticalAsc() {
        return cargoRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }
    
    // 13. Sort by Alphabetical (Descending)
    public List<Cargo> sortByAlphabeticalDesc() {
        return cargoRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
    }
    
    // 14. Sort by Creation Date (Ascending)
    public List<Cargo> sortByCreationDateAsc() {
        return cargoRepository.findAll(Sort.by(Sort.Direction.ASC, "createdAt"));
    }
    
    // 15. Sort by Creation Date (Descending)
    public List<Cargo> sortByCreationDateDesc() {
        return cargoRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }
    
    // 16. Search by Cargo Name + Filter by Status
    public List<Cargo> searchByCargoNameAndStatus(String name, int statusId) {
        return cargoRepository.findByNameContainingIgnoreCaseAndStatusId(name, statusId);
    }
    
    // 17. Search by Cargo Name + Sort by Alphabetical (Ascending)
    public List<Cargo> searchByCargoNameAndSortAlphabeticalAsc(String name) {
        List<Cargo> cargos = cargoRepository.findByNameContainingIgnoreCase(name);
        cargos.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return cargos;
    }
    
    // 18. Search by Cargo Name + Sort by Alphabetical (Descending)
    public List<Cargo> searchByCargoNameAndSortAlphabeticalDesc(String name) {
        List<Cargo> cargos = cargoRepository.findByNameContainingIgnoreCase(name);
        cargos.sort((c1, c2) -> c2.getName().compareToIgnoreCase(c1.getName()));
        return cargos;
    }
}
