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
import com.group1.capstone.model.Port;
import com.group1.capstone.service.PortService;

@RestController
@RequestMapping("/api/port")
public class PortController {

    private final PortService portService;

    public PortController(PortService portService) {
        this.portService = portService;
    }

    // 1. Get all ports
    @GetMapping
    public ResponseEntity<List<Port>> getAllPorts() {
        return ResponseEntity.ok(portService.getAllPorts());
    }

    // 2. Get port by ID
    @GetMapping("/{id}")
    public ResponseEntity<Port> getPortById(@PathVariable int id) {
        return ResponseEntity.ok(portService.getPortById(id));
    }

    // 3. Get port count
    @GetMapping("/count")
    public ResponseEntity<Long> getPortCount() {
        return ResponseEntity.ok(portService.getPortCount());
    }

    // 4. Add new port
    @PostMapping
    public ResponseEntity<Port> addPort(@RequestBody Port port) {
        return ResponseEntity.ok(portService.addPort(port));
    }

    // 5. Update port
    @PutMapping("/{id}")
    public ResponseEntity<Port> updatePort(@PathVariable int id, @RequestBody Port updatedPort) {
        return ResponseEntity.ok(portService.updatePort(id, updatedPort));
    }

    // 6. Delete port
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePort(@PathVariable int id) {
        portService.deletePort(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}
 
