package com.w2g4.w2g4.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="trackingevent")
public class TrackingEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tracking_event_id")
    private Long tracking_event_id;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "package_status_id")
    private PackageStatus packageStatus;
    
    @ManyToOne
    @JoinColumn(name = "package_id")
    private Package pkg;
    
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
    
    @Column(name = "created_at")
    private Timestamp created_at;
    
    @Column(name = "updated_at")
    private Timestamp updated_at;
}
