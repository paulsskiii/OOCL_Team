package com.w2g4.w2g4.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.w2g4.w2g4.exceptions.TrackingEventNotFoundException;
import com.w2g4.w2g4.model.TrackingEvent;
import com.w2g4.w2g4.repository.TrackingEventRepository;

@Service
public class TrackingEventService {
    private final TrackingEventRepository trackingEventRepository;

    public TrackingEventService(TrackingEventRepository trackingEventRepository) {
        this.trackingEventRepository = trackingEventRepository;
    }

    public List<TrackingEvent> getAllTrackingEvents() {
        return trackingEventRepository.findAll();
    }

    public TrackingEvent getTrackingEventById(Long id) {
        return trackingEventRepository.findById(id)
                .orElseThrow(() -> new TrackingEventNotFoundException("Tracking event item with ID " + id + " not found."));
    }

    public Map<String, Long> getCountPerPackageStatus() {
        return trackingEventRepository.countTrackingEventsPerStatus()
        .stream()
        .collect(Collectors.toMap(
            row -> (String) row[0], 
            row -> (Long) row[1]
            ));
    }
}
