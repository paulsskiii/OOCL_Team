package com.w2g4.w2g4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.w2g4.w2g4.model.TrackingEvent;

@Repository
public interface TrackingEventRepository extends JpaRepository<TrackingEvent, Long>{
    @Query(value = "SELECT DISTINCT b.status_name, COUNT(*) " + 
                    "FROM TrackingEvent a " + 
                    "INNER JOIN PackageStatus b " + 
                    "ON a.package_status_id = b.package_status_id " +
                    "GROUP BY b.status_name ", nativeQuery = true)
    List<Object[]> countTrackingEventsPerStatus();
}
