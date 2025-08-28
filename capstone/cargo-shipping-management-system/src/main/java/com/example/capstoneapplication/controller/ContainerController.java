package com.example.capstoneapplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.capstoneapplication.model.Container;
import com.example.capstoneapplication.service.ContainerService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/container")
@CrossOrigin(origins = "http://localhost:3000")
public class ContainerController {


    private final ContainerService containerService;

    public ContainerController(ContainerService containerService){
        this.containerService = containerService;
    }

    @GetMapping
    public ResponseEntity<List<Container>> getAllContainer() {
        return ResponseEntity.ok(containerService.getAllContainer());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Container>> getContainerById(@PathVariable Long id) {
        return ResponseEntity.ok(containerService.getContainerById(id));
    }

    @PostMapping
    public ResponseEntity<Container> addContainer(@RequestBody Container container) {
        return ResponseEntity.ok(containerService.addContainers(container));
    }

    @DeleteMapping("/{id}")
    public void deleteContainer(@PathVariable Long id) {
        containerService.deleteContainer(id);
    }


}
