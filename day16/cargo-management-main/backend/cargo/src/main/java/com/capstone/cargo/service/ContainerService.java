package com.capstone.cargo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capstone.cargo.producer.KafkaProducer;
import com.capstone.cargo.model.Container;
import com.capstone.cargo.repository.ContainerRepository;

@Service
public class ContainerService {
    @Autowired
    private ContainerRepository containerRepository;
    
    @Autowired
    private KafkaProducer kafkaProducer;


    public List <Container> getAll (){
        return containerRepository.findAll();
    }

    public Container addContainer(Container container) {
        Container newContainer = containerRepository.save(container);
//        kafkaProducer.sendMessage(container);
        return newContainer;
    }

    public Container updateContainer(Long id, Container updatedContainer) {
        return containerRepository.findById(id)
                .map(existingContainer -> {
                    existingContainer.setContainerType(updatedContainer.getContainerType());
                    existingContainer.setOwner(updatedContainer.getOwner());
                    existingContainer.setDestination(updatedContainer.getDestination());
                    existingContainer.setOrigin(updatedContainer.getOrigin());
                    return containerRepository.save(existingContainer);
                })
                .orElseThrow(() -> new IllegalArgumentException("ID does not exist"));
    }

    public boolean  deleteContainer(Long id) {
        Container foundContainer = containerRepository.findById(id).orElse(null);
        if (foundContainer != null) {
            containerRepository.delete(foundContainer);
            return true;
        }
        return false;
    }

}
