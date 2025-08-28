package com.group1.capstone.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.group1.capstone.model.TrackingEvent;
import com.group1.capstone.service.TrackingEventService;

@RestController
@RequestMapping("/api/tracking-event")
public class TrackingEventController {

    private final TrackingEventService trackingEventService;

    public TrackingEventController(TrackingEventService trackingEventService) {
        this.trackingEventService = trackingEventService;
    }


    // 1. Get all tracking events
    @GetMapping
    public ResponseEntity<List<TrackingEvent>> getAllTrackingEvents() {
        return ResponseEntity.ok(trackingEventService.getAllTrackingEvents());
    }

    // 2. Get tracking event by ID
    @GetMapping("/{id}")
    public ResponseEntity<TrackingEvent> getPortById(@PathVariable Long id) {
        return ResponseEntity.ok(trackingEventService.getTrackingEventById(id));
    }

    // 3. Get tracking event count
    @GetMapping("/count")
    public ResponseEntity<Long> getTrackingEventCount() {
        return ResponseEntity.ok(trackingEventService.getTrackingEventCount());
    }

    // 4. Add new tracking event
    @PostMapping
    public ResponseEntity<TrackingEvent> addTrackingEvent(@RequestBody TrackingEvent trackingEvent) {
        return ResponseEntity.ok(trackingEventService.addTrackingEvent(trackingEvent));
    }

    // 5. Update tracking event
    @PutMapping("/{id}")
    public ResponseEntity<TrackingEvent> updateTrackingEvent(@PathVariable Long id, @RequestBody TrackingEvent updatedTrackingEvent) {
        return ResponseEntity.ok(trackingEventService.updateTrackingEvent(id, updatedTrackingEvent));
    }

    // 6. Delete tracking event
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrackingEvent(@PathVariable Long id) {
        trackingEventService.deleteTrackingEvent(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}
 

