package com.group1.capstone.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group1.capstone.model.Cargo;
import com.group1.capstone.service.CargoService;

@RestController
@RequestMapping("/api/cargo")
public class CargoController {

    private final CargoService cargoService;

    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    // 1. Get all cargos
    @GetMapping
    public ResponseEntity<List<Cargo>> getAllCargos() {
        return ResponseEntity.ok(cargoService.getAllCargos());
    }

    // 2. Get cargo by ID
    @GetMapping("/{id}")
    public ResponseEntity<Cargo> getCargoById(@PathVariable int id) {
        return ResponseEntity.ok(cargoService.getCargoById(id));
    }

    // 3. Get cargo count
    @GetMapping("/count")
    public ResponseEntity<Long> getCargoCount() {
        return ResponseEntity.ok(cargoService.getCargoCount());
    }

    // 4. Add new cargo
    @PostMapping
    public ResponseEntity<Cargo> addCargo(@RequestBody Cargo cargo) {
        return ResponseEntity.ok(cargoService.addCargo(cargo));
    }

    // 5. Update cargo
    @PutMapping("/{id}")
    public ResponseEntity<Cargo> updateCargo(@PathVariable int id, @RequestBody Cargo updatedCargo) {
        return ResponseEntity.ok(cargoService.updateCargo(id, updatedCargo));
    }

    // 6. Delete cargo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCargo(@PathVariable int id) {
        cargoService.deleteCargo(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}
 