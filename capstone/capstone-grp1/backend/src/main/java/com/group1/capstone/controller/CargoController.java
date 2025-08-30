package com.group1.capstone.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    // GET /api/cargo/destination/{portCode}/date/{date}
    // GET /api/cargo/destination/5/date/2024-01-15
    @GetMapping("/destination/{portCode}/date/{date}")
    public ResponseEntity<List<Cargo>> getCargoGoingToPortOnDate(
            @PathVariable String portCode,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(cargoService.getCargoGoingToPortOnDate(portCode, date));
    }

    // 8. Get all cargo coming from selected location for the day
    // GET /api/cargo/origin/{portCode}/date/{date}
    // GET /api/cargo/origin/3/date/2024-01-15
    @GetMapping("/origin/{portCode}/date/{date}")
    public ResponseEntity<List<Cargo>> getCargoComingFromPortOnDate(
            @PathVariable String portCode,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(cargoService.getCargoComingFromPortOnDate(portCode, date));
    }

    // 9. Get all cargo moving for the day, month, year
    // GET /api/cargo/moving/filter?from=2024-01-01&to=2025-08-29
    @GetMapping("/moving/filter")
    public ResponseEntity<List<Cargo>> getCargoMovingOnDate(
            @RequestParam(value = "from", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam(value = "to", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
        return ResponseEntity.ok(cargoService.getCargoMovingOnDate(from, to));
    }

    // 10. Search by Cargo Name
    // GET /api/cargo/search/name?q=electronics
    @GetMapping("/search/name")
    public ResponseEntity<List<Cargo>> searchByCargoName(@RequestParam("q") String name) {
        return ResponseEntity.ok(cargoService.searchByCargoName(name));
    }
    
    // 11. Filter by Status
    // GET /api/cargo/filter/status?statusId=1
    @GetMapping("/filter/status")
    public ResponseEntity<List<Cargo>> filterByStatus(@RequestParam("statusId") int statusId) {
        return ResponseEntity.ok(cargoService.filterByStatus(statusId));
    }
    
    // 12. Sort by Alphabetical (Ascending)
    // GET /api/cargo/sort/name/asc
    @GetMapping("/sort/name/asc")
    public ResponseEntity<List<Cargo>> sortByAlphabeticalAsc() {
        return ResponseEntity.ok(cargoService.sortByAlphabeticalAsc());
    }
    
    // 13. Sort by Alphabetical (Descending)
    // GET /api/cargo/sort/name/desc
    @GetMapping("/sort/name/desc")
    public ResponseEntity<List<Cargo>> sortByAlphabeticalDesc() {
        return ResponseEntity.ok(cargoService.sortByAlphabeticalDesc());
    }
    
    // 14. Sort by Creation Date (Ascending)
    // GET /api/cargo/sort/date/asc
    @GetMapping("/sort/date/asc")
    public ResponseEntity<List<Cargo>> sortByCreationDateAsc() {
        return ResponseEntity.ok(cargoService.sortByCreationDateAsc());
    }
    
    // 15. Sort by Creation Date (Descending)
    // GET /api/cargo/sort/date/desc
    @GetMapping("/sort/date/desc")
    public ResponseEntity<List<Cargo>> sortByCreationDateDesc() {
        return ResponseEntity.ok(cargoService.sortByCreationDateDesc());
    }
    
    // 16. Search by Cargo Name + Filter by Status
    // GET /api/cargo/search/name-status?name=electronics&statusId=1
    @GetMapping("/search/name-status")
    public ResponseEntity<List<Cargo>> searchByCargoNameAndStatus(
            @RequestParam("name") String name,
            @RequestParam("statusId") int statusId) {
        return ResponseEntity.ok(cargoService.searchByCargoNameAndStatus(name, statusId));
    }
    
    // 17. Search by Cargo Name + Sort by Alphabetical (Ascending)
    // GET /api/cargo/search/name-sort-asc?name=electronics
    @GetMapping("/search/name-sort-asc")
    public ResponseEntity<List<Cargo>> searchByCargoNameAndSortAlphabeticalAsc(@RequestParam("name") String name) {
        return ResponseEntity.ok(cargoService.searchByCargoNameAndSortAlphabeticalAsc(name));
    }
    
    // 18. Search by Cargo Name + Sort by Alphabetical (Descending)
    // GET /api/cargo/search/name-sort-desc?name=electronics
    @GetMapping("/search/name-sort-desc")
    public ResponseEntity<List<Cargo>> searchByCargoNameAndSortAlphabeticalDesc(@RequestParam("name") String name) {
        return ResponseEntity.ok(cargoService.searchByCargoNameAndSortAlphabeticalDesc(name));
    }

}
