package com.group1.capstone.service;

import com.group1.capstone.exceptions.TrackingEventNotFoundException;
import com.group1.capstone.model.TrackingEvent;
import com.group1.capstone.repository.TrackingEventRepository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackingEventService {
    @Autowired
    private TrackingEventRepository trackingEventRepository;

    // 1. Find all TrackingEvent
    public List<TrackingEvent> getAllTrackingEvents() {
        return trackingEventRepository.findAll();
    }

    // 2. Find TrackingEvent by ID
    public TrackingEvent getTrackingEventById(Long id) {
        return trackingEventRepository.findById(id)
                .orElseThrow(() -> new TrackingEventNotFoundException("Tracking Event with ID " + id + " not found."));
    }

    // 3. Get TrackingEvent count
    public long getTrackingEventCount() {
        return trackingEventRepository.count();
    }

    // 4. Add TrackingEvent
    public TrackingEvent addTrackingEvent(TrackingEvent trackingEvent) {
        return trackingEventRepository.save(trackingEvent);
    }

    // 5. Update TrackingEvent    
    public TrackingEvent updateTrackingEvent(Long id, TrackingEvent updatedTrackingEvent) {
        return trackingEventRepository.findById(id).map(trackingEvent -> {
            trackingEvent.setCargo(updatedTrackingEvent.getCargo());
            trackingEvent.setStatus(updatedTrackingEvent.getStatus());
            trackingEvent.setUpdatedAt(LocalDateTime.now());

            return trackingEventRepository.save(trackingEvent);
        }).orElseThrow(() -> new TrackingEventNotFoundException("Tracking Event with ID " + id + " not found."));
    }
    
    // 6. Delete TrackingEvent
    public void deleteTrackingEvent(Long id) {
        if (!trackingEventRepository.existsById(id)) {
            throw new TrackingEventNotFoundException("Tracking Event with ID " + id + " not found.");
        }
        trackingEventRepository.deleteById(id);
    }
}
