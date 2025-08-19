package com.example.excer2.service;

import java.util.List;
import java.util.Optional;

import com.example.excer2.model.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.excer2.repository.ContainerRepository;

@Service
public class ContainerService {

    @Autowired
    private ContainerRepository containerRepository;

    public List<Container> getAllContainers() {
        return containerRepository.findAll();
    }

    public Optional<Container> getContainerById(Long id) {
        return containerRepository.findById(id); // Uses JpaRepository's findById()
    }

    public Container addContainer (Container container) {
        return containerRepository.save(container); // Uses JpaRepository's save() for create/update
    }

    public Container updateContainer (Container container) {
        return containerRepository.save(container);
    }

    public void deleteContainer (Long id) {
        containerRepository.deleteById(id);
    }

}
