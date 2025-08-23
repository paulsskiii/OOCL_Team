package com.capstone.cargo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.cargo.model.Container;
import com.capstone.cargo.service.ContainerService;
import com.capstone.cargo.service.MessagingService;

@RestController
@RequestMapping ("/api/containers")
@CrossOrigin(origins = "http://localhost:5173")
public class ContainerController {

    @Autowired
    private ContainerService containerService;
    @Autowired
    private MessagingService messagingService;
    
    @GetMapping
    public ResponseEntity<List<Container>> getContainers(){
        List<Container> getAll = containerService.getAll();
        return new ResponseEntity<>(getAll, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Container> createContainer(@RequestBody Container container){
        Container newContainer = containerService.addContainer(container);
        messagingService.sendContainer(newContainer);

        return new ResponseEntity<>(newContainer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Container> updateContainerItem(@PathVariable Long id, @RequestBody Container containerItem) {
        Container updatedContainer = containerService.updateContainer(id, containerItem);
        return ResponseEntity.ok(updatedContainer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContainer(@PathVariable Long id){
        return containerService.deleteContainer(id) ?
                new ResponseEntity<>("Container deleted", HttpStatus.OK)
                : new ResponseEntity<>("Container not found", HttpStatus.NOT_FOUND);
    }
}
 