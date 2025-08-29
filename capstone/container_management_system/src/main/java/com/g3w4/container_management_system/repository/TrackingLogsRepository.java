package com.g3w4.container_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g3w4.container_management_system.model.TrackingLogs;

@Repository
public interface TrackingLogsRepository extends JpaRepository<TrackingLogs, Integer> {
    
}