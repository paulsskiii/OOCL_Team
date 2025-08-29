package com.g3w4.container_management_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g3w4.container_management_system.repository.TrackingStatusRepository;
import com.g3w4.container_management_system.model.TrackingStatus;

@Service
public class TrackingStatusService {
    @Autowired
    private final TrackingStatusRepository trackingStatusRepository;

    public TrackingStatusService(TrackingStatusRepository trackingStatusRepository){
        this.trackingStatusRepository = trackingStatusRepository;
    }

    public List<TrackingStatus> getAllTrackingStatus(){
        return trackingStatusRepository.findAll();
    } 

    public Optional<TrackingStatus> getTrackingStatusById(Integer id) {
        return trackingStatusRepository.findById(id); // Uses JpaRepository's findById()
    }

    public TrackingStatus addTrackingStatus(TrackingStatus trackingStatus) {
        return trackingStatusRepository.save(trackingStatus); // Uses JpaRepository's save() for create/update
    }

    public void deleteTrackingStatus(Integer id) {
        trackingStatusRepository.deleteById(id); // Uses JpaRepository's deleteById()
    }
}
