package com.g3w4.container_management_system.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g3w4.container_management_system.model.Ports;
import com.g3w4.container_management_system.service.PortsService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/ports")
@CrossOrigin(origins = "http://localhost:3000")
public class PortsController {


    private final PortsService portsService;

    public PortsController(PortsService portsService){
        this.portsService = portsService;
    }

    @GetMapping
    public ResponseEntity<List<Ports>> getAllPorts() {
        return ResponseEntity.ok(portsService.getAllPort());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ports> getPortsById(@PathVariable Integer id) {
        return portsService.getPortById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    
    @PostMapping
    public ResponseEntity<Ports> addPorts(@RequestBody Ports ports) {
        String regex = "[^a-zA-Z0-9 ]"; 
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ports.getPortName());
        if(matcher.find()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(portsService.addPort(ports));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePorts(@PathVariable Integer id) {
        if (portsService.getPortById(id).isPresent()) {
            portsService.deletePort(id);
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
