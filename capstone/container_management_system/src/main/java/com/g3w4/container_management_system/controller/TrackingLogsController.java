package com.g3w4.container_management_system.controller;

import java.util.List;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g3w4.container_management_system.model.TrackingLogs;
import com.g3w4.container_management_system.service.TrackingLogService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/tracking-logs")
@CrossOrigin(origins = "http://localhost:3000")
public class TrackingLogsController {


    private final TrackingLogService trackingLogService;

    public TrackingLogsController(TrackingLogService trackingLogService){
        this.trackingLogService = trackingLogService;
    }

    @GetMapping
    public ResponseEntity<List<TrackingLogs>> getAllTrackingLogs() {
        return ResponseEntity.ok(trackingLogService.getAllTrackingLogs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrackingLogs> getTrackingLogstById(@PathVariable Integer id) {
        return trackingLogService.getTrackingLogsById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    
    @PostMapping
    public ResponseEntity<TrackingLogs> addTrackingLogs(@RequestBody TrackingLogs trackingLogs) {
        TrackingLogs newTrackingLogs = trackingLogService.addTrackingLogs(trackingLogs);
        return new ResponseEntity<>(newTrackingLogs, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrackingLogs(@PathVariable Integer id) {
        if (trackingLogService.getTrackingLogsById(id).isPresent()) {
            trackingLogService.deleteTrackingLogs(id);
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
