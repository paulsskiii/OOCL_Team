package com.group1.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group1.capstone.model.TrackingEvent;

@Repository
public interface TrackingEventRepository extends JpaRepository<TrackingEvent, Integer> {
    
}
