package com.example.excer2.service;

import java.util.List;

import com.example.excer2.ContainerProducer;
import com.example.excer2.model.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.excer2.repository.ContainerRepository;

@Service
public class ContainerService {

    @Autowired
    private ContainerRepository containerRepository;
    @Autowired
    private ContainerProducer containerProducer;

    public List<Container> getAllContainers() {
        return containerRepository.findAll();
    }

    public List<Container> getContainerById(String id) {
        return containerRepository.findByContainerNumber(id); // Uses JpaRepository's findById()
    }

    public Container addContainer (Container container) {
        containerProducer.sendMessage("AddContainer", container);
        return containerRepository.save(container); // Uses JpaRepository's save() for create/update
    }

    public Container updateContainer (Container container) {
        containerProducer.sendMessage("UpdateContainer", container);
        return containerRepository.save(container);
    }

    public void deleteContainer (Container container) {
        containerProducer.sendMessage("DeleteContainer", container);
        containerRepository.deleteById(container.getContainerNumber());
    }

}
 