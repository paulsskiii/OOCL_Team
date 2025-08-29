package com.g3w4.container_management_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g3w4.container_management_system.repository.TrackingLogsRepository;
import com.g3w4.container_management_system.model.TrackingLogs;

@Service
public class TrackingLogService {
    @Autowired
    private final TrackingLogsRepository trackingLogRepository;

    public TrackingLogService(TrackingLogsRepository trackingLogRepository){
        this.trackingLogRepository = trackingLogRepository;
    }

    public List<TrackingLogs> getAllTrackingLogs(){
        return trackingLogRepository.findAll();
    } 

    public Optional<TrackingLogs> getTrackingLogsById(Integer id) {
        return trackingLogRepository.findById(id); // Uses JpaRepository's findById()
    }

    public TrackingLogs addTrackingLogs(TrackingLogs trackingLogs) {
        return trackingLogRepository.save(trackingLogs); // Uses JpaRepository's save() for create/update
    }

    public void deleteTrackingLogs(Integer id) {
        trackingLogRepository.deleteById(id); // Uses JpaRepository's deleteById()
    }
}
