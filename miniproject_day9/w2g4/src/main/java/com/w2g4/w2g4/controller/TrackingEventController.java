package com.w2g4.w2g4.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.w2g4.w2g4.model.TrackingEvent;
import com.w2g4.w2g4.service.TrackingEventService;




@RestController
@RequestMapping("/api/trackingEvents")
public class TrackingEventController {
    
    private final TrackingEventService trackingEventService;

    public TrackingEventController(TrackingEventService trackingEventService){
        this.trackingEventService = trackingEventService;
    }

    // Get all records in TrackingEvent
    @GetMapping
    public ResponseEntity<List<TrackingEvent>> getAllTrackingEvents() {
        return ResponseEntity.ok(trackingEventService.getAllTrackingEvents());
    }
    
    // Get specific TrackingEvent record by ID
    @GetMapping("/{trackingEventId}")
    public ResponseEntity getTrackingEventById(@PathVariable Long trackingEventId) {
        return ResponseEntity.ok(trackingEventService.getTrackingEventById(trackingEventId));
    }
    
    // Get counts for each status to be displayed in a chart
    @GetMapping("/countPerPackageStatus")
    public ResponseEntity getCountByPackageStatus() {
        return ResponseEntity.ok(trackingEventService.getCountPerPackageStatus());
    }
    
}
