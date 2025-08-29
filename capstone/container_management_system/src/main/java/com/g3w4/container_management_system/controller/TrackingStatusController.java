package com.g3w4.container_management_system.controller;

import java.util.List;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g3w4.container_management_system.model.TrackingStatus;
import com.g3w4.container_management_system.service.TrackingStatusService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/tracking-status")
@CrossOrigin(origins = "http://localhost:3000")
public class TrackingStatusController {


    private final TrackingStatusService trackingStatusService;

    public TrackingStatusController(TrackingStatusService trackingStatusService){
        this.trackingStatusService = trackingStatusService;
    }

    @GetMapping
    public ResponseEntity<List<TrackingStatus>> getAllTrackingStatus() {
        return ResponseEntity.ok(trackingStatusService.getAllTrackingStatus());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrackingStatus> getTrackingStatustById(@PathVariable Integer id) {
        return trackingStatusService.getTrackingStatusById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    
    @PostMapping
    public ResponseEntity<TrackingStatus> addTrackingStatus(@RequestBody TrackingStatus trackingStatus) {
        TrackingStatus newTrackingStatus = trackingStatusService.addTrackingStatus(trackingStatus);
        return new ResponseEntity<>(newTrackingStatus, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrackingStatus(@PathVariable Integer id) {
        if (trackingStatusService.getTrackingStatusById(id).isPresent()) {
            trackingStatusService.deleteTrackingStatus(id);
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
