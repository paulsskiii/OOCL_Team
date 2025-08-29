package com.g3w4.container_management_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g3w4.container_management_system.model.TrackingEvent;
import com.g3w4.container_management_system.service.TrackingEventService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/tracking-events")
@CrossOrigin(origins = "http://localhost:3000")
public class TrackingEventController {


    private final TrackingEventService trackingEventService;

    public TrackingEventController(TrackingEventService trackingEventService){
        this.trackingEventService = trackingEventService;
    }

    @GetMapping
    public ResponseEntity<List<TrackingEvent>> getAllTrackingEvents() {
        return ResponseEntity.ok(trackingEventService.getAllTrackingEvents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrackingEvent> getTrackingEventstById(@PathVariable Integer id) {
        return trackingEventService.getTrackingEventsById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    
    @PostMapping
    public ResponseEntity<TrackingEvent> addTrackingEvents(@RequestBody TrackingEvent trackingEvent) {
        TrackingEvent newTrackingEvent = trackingEventService.addTrackingEvents(trackingEvent);
        return new ResponseEntity<>(newTrackingEvent, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrackingEvents(@PathVariable Integer id) {
        if (trackingEventService.getTrackingEventsById(id).isPresent()) {
            trackingEventService.deleteTrackingEvents(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    

    //  @PutMapping("/{id}")
    // public ResponseEntity<Ports> updatePort(@PathVariable Integer id, @RequestBody Ports portsDetails) {
    //     return portsService.getPortById(id)
    //             .map(port -> {
    //                 port.setPortName(portsDetails.getPortName());
    //                 return ResponseEntity.ok(portsService.updatePort(port));
    //             }).orElse(ResponseEntity.notFound().build());
    // }
}
