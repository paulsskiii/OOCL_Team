package com.group1.capstone.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group1.capstone.exceptions.StatusNotFoundException;
import com.group1.capstone.model.Status;
import com.group1.capstone.repository.StatusRepository;

@Service
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;

    // 1. Find all status
    public List<Status> getAllStatus() {
        return statusRepository.findAll();
    }

    // 2. Find status by ID
    public Status getStatusById(Long id) {
        return statusRepository.findById(id)
                .orElseThrow(() -> new StatusNotFoundException("Status with ID " + id + " not found."));
    }

    // 3. Get status count
    public long getStatusCount() {
        return statusRepository.count();
    }

    // 4. Add status
    public Status addStatus(Status status) {
        return statusRepository.save(status);
    }

    // 5. Update status    
    public Status updateStatus(Long id, Status updatedStatus) {
        return statusRepository.findById(id).map(status -> {
            status.setStatusType(updatedStatus.getStatusType());
            status.setStatusCode(updatedStatus.getStatusCode());
            status.setUpdatedAt(LocalDateTime.now());

            return statusRepository.save(status);
        }).orElseThrow(() -> new StatusNotFoundException("Status with ID " + id + " not found."));
    }
    
    // 6. Delete status
    public void deleteStatus(Long id) {
        if (!statusRepository.existsById(id)) {
            throw new StatusNotFoundException("Status with ID " + id + " not found.");
        }
        statusRepository.deleteById(id);
    }


}
