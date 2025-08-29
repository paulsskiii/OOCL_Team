package com.group1.capstone.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.group1.capstone.model.Status;
import com.group1.capstone.service.StatusService;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    // 1. Get all status
    @GetMapping
    public ResponseEntity<List<Status>> getAllStatus() {
        return ResponseEntity.ok(statusService.getAllStatus());
    }

    // 2. Get status by ID
    @GetMapping("/{statusCode}")
    public ResponseEntity<Status> getStatusById(@PathVariable String statusCode) {
        return ResponseEntity.ok(statusService.getStatusById(statusCode));
    }

    // 3. Get status count
    @GetMapping("/count")
    public ResponseEntity<Long> getStatusCount() {
        return ResponseEntity.ok(statusService.getStatusCount());
    }

    // 4. Add new status
    @PostMapping
    public ResponseEntity<Status> addStatus(@RequestBody Status status) {
        return ResponseEntity.ok(statusService.addStatus(status));
    }

    // 5. Update status
    @PutMapping("/{statusCode}")
    public ResponseEntity<Status> updateStatus(@PathVariable String statusCode, @RequestBody Status updatedStatus) {
        return ResponseEntity.ok(statusService.updateStatus(statusCode, updatedStatus));
    }

    // 6. Delete status
    @DeleteMapping("/{statusCode}")
    public ResponseEntity<Void> deleteStatus(@PathVariable String statusCode) {
        statusService.deleteStatus(statusCode);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
}
 