package com.example.capstoneapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.capstoneapplication.model.Container;
import com.example.capstoneapplication.repository.ContainerRepository;

@Service
public class ContainerService {
    @Autowired
    private final  ContainerRepository containerRepository;

      public ContainerService(ContainerRepository containerRepository) {
        this.containerRepository = containerRepository;
    }

    public List<Container> getAllContainer() {
        return containerRepository.findAll(); // Uses JpaRepository's findAll()
    }

    public Optional<Container> getContainerById(Long id) {
        return containerRepository.findById(id); // Uses JpaRepository's findById()
    }

    public Container addContainers(Container container) {
        return containerRepository.save(container); // Uses JpaRepository's save() for create/update
    }

    public void deleteContainer(Long id) {
        containerRepository.deleteById(id); // Uses JpaRepository's deleteById()
    }
    
    public Long countbyDestination (Long id, String destination) {
        List<Container> containerList = containerRepository.findAll();

        return containerList.stream()
            .filter(container -> container.getDestination().toUpperCase() == destination.toUpperCase())
            .count();
    }

    public Long countbyOrigin (Long id, String origin) {
        List<Container> containerList = containerRepository.findAll();

        return containerList.stream()
            .filter(container -> container.getOrigin().toUpperCase() == origin.toUpperCase())
            .count();
    }
}
