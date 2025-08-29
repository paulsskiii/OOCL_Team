package com.g3w4.container_management_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g3w4.container_management_system.model.Container;
import com.g3w4.container_management_system.repository.ContainerRepository;



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

    public Optional<Container> getContainerById(Integer id) {
        return containerRepository.findById(id); // Uses JpaRepository's findById()
    }

    public Container addContainers(Container container) {
        return containerRepository.save(container); // Uses JpaRepository's save() for create/update
    }

    public void deleteContainer(Integer id) {
        containerRepository.deleteById(id); // Uses JpaRepository's deleteById()
    }
    
    public Container updateContainer(Container container) {
        return containerRepository.save(container); // Uses JpaRepository's save() for create/update
    }
}
