package com.g3w4.container_management_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g3w4.container_management_system.model.Roles;
import com.g3w4.container_management_system.service.RolesService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "http://localhost:3000")
public class RolesController {


    private final RolesService rolesService;

    public RolesController(RolesService rolesService){
        this.rolesService = rolesService;
    }

    @GetMapping
    public ResponseEntity<List<Roles>> getAllContainer() {
        return ResponseEntity.ok(rolesService.getAllRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Roles> getPortById(@PathVariable Integer id) {
        return rolesService.getRolesById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Roles> addTrackingEvents(@RequestBody Roles roles) {
        Roles newRoles = rolesService.addRoles(roles);
        return new ResponseEntity<>(newRoles, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrackingEvents(@PathVariable Integer id) {
        if (rolesService.getRolesById(id).isPresent()) {
            rolesService.deleteRoles(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    

    //  @PutMapping("/{id}")
    // public ResponseEntity<Ports> updatePort(@PathVariable Long id, @RequestBody Ports portsDetails) {
    //     return portsService.getPortById(id)
    //             .map(port -> {
    //                 port.setPortName(portsDetails.getPortName());
    //                 return ResponseEntity.ok(portsService.updatePort(port));
    //             }).orElse(ResponseEntity.notFound().build());
    // }
}
