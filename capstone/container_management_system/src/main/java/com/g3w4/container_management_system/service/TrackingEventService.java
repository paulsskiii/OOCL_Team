package com.g3w4.container_management_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g3w4.container_management_system.repository.TrackingEventRepository;
import com.g3w4.container_management_system.model.TrackingEvent;

@Service
public class TrackingEventService {
    @Autowired
    private final TrackingEventRepository trackingEventRepository;

    public TrackingEventService(TrackingEventRepository trackingEventRepository){
        this.trackingEventRepository = trackingEventRepository;
    }

    public List<TrackingEvent> getAllTrackingEvents(){
        return trackingEventRepository.findAll();
    } 

    public Optional<TrackingEvent> getTrackingEventsById(Integer id) {
        return trackingEventRepository.findById(id); // Uses JpaRepository's findById()
    }

    public TrackingEvent addTrackingEvents(TrackingEvent trackingevent) {
        return trackingEventRepository.save(trackingevent); // Uses JpaRepository's save() for create/update
    }

    public void deleteTrackingEvents(Integer id) {
        trackingEventRepository.deleteById(id); // Uses JpaRepository's deleteById()
    }
}
