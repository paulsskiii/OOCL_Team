package com.example.day12miniproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.day12miniproject.model.Container;
import com.example.day12miniproject.service.ContainerService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/container")
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
    public ResponseEntity<Container> addContainer(Container container) {
        return ResponseEntity.ok(containerService.addContainers(container));
    }

    @DeleteMapping
    public void deleteContainer(@PathVariable Long id) {
        containerService.deleteContainer(id);
    }


}
