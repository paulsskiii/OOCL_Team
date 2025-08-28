package com.group1.capstone.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    // 7. Get all cargo going to selected location for the day
    // GET /api/cargo/destination/{portId}/date/{date}
    // GET /api/cargo/destination/5/date/2024-01-15
    @GetMapping("/destination/{portId}/date/{date}")
    public ResponseEntity<List<Cargo>> getCargoGoingToPortOnDate(
            @PathVariable int portId, 
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(cargoService.getCargoGoingToPortOnDate(portId, date));
    }
    
    // 8. Get all cargo coming from selected location for the day
    // GET /api/cargo/origin/{portId}/date/{date}
    // GET /api/cargo/origin/3/date/2024-01-15
    @GetMapping("/origin/{portId}/date/{date}")
    public ResponseEntity<List<Cargo>> getCargoComingFromPortOnDate(
            @PathVariable int portId, 
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(cargoService.getCargoComingFromPortOnDate(portId, date));
    }
    
    // 9. Get all cargo moving for the day, month, year
    // GET /api/cargo/moving/date/{date}
    // GET /api/cargo/moving?year=2024&month=1&day=15
    // GET /api/cargo/moving/date/2024-01-15
    @GetMapping("/moving/date/{date}")
    public ResponseEntity<List<Cargo>> getCargoMovingOnDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(cargoService.getCargoMovingOnDate(date));
    }
    
    // 10. Alternative endpoint for cargo moving on specific year/month/day
    @GetMapping("/moving")
    public ResponseEntity<List<Cargo>> getCargoMovingOnDate(
            @RequestParam int year,
            @RequestParam int month,
            @RequestParam int day) {
        return ResponseEntity.ok(cargoService.getCargoMovingOnDate(year, month, day));
    }
}
 