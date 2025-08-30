package com.group1.capstone.service;

import com.group1.capstone.exceptions.TrackingEventNotFoundException;
import com.group1.capstone.model.TrackingEvent;
import com.group1.capstone.repository.CargoRepository;
import com.group1.capstone.repository.StatusRepository;
import com.group1.capstone.repository.TrackingEventRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackingEventService {
    @Autowired
    private ProducerService producerService;

    @Autowired
    private TrackingEventRepository trackingEventRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private CargoService cargoService;

    // 1. Find all TrackingEvent
    public List<TrackingEvent> getAllTrackingEvents() {
        return trackingEventRepository.findAll();
    }

    // 2. Find TrackingEvent by ID
    public TrackingEvent getTrackingEventById(int id) {
        return trackingEventRepository.findById(id)
                .orElseThrow(() -> new TrackingEventNotFoundException("Tracking Event with ID " + id + " not found."));
    }

    // 3. Get TrackingEvent count
    public long getTrackingEventCount() {
        return trackingEventRepository.count();
    }

    // 4. Add TrackingEvent
    public TrackingEvent addTrackingEvent(TrackingEvent trackingEvent) {
        producerService.sendMessage(trackingEvent, "Delivered", cargoService.getCargoById(trackingEvent.getCargoId()).getName(), "CREATED");
        return trackingEventRepository.save(trackingEvent);
    }

    // 5. Update TrackingEvent    
    public TrackingEvent updateTrackingEvent(int id, TrackingEvent updatedTrackingEvent) {
        return trackingEventRepository.findById(id).map(trackingEvent -> {
            trackingEvent.setCargoId(updatedTrackingEvent.getCargoId());
            trackingEvent.setStatusId(updatedTrackingEvent.getStatusId());

            return trackingEventRepository.save(trackingEvent);
        }).orElseThrow(() -> new TrackingEventNotFoundException("Tracking Event with ID " + id + " not found."));
    }
    
    // 6. Delete TrackingEvent
    public void deleteTrackingEvent(int id) {
        if (!trackingEventRepository.existsById(id)) {
            throw new TrackingEventNotFoundException("Tracking Event with ID " + id + " not found.");
        }
        trackingEventRepository.deleteById(id);
    }
}
