package com.g3w4.container_management_system.model;

import java.sql.Date;

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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tracking_events")
public class TrackingEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tracking_events_id")
    private int trackingEventsId;

    @Column(name = "arrival_at")
    private Date arrivalAt;

    @Column(name = "departure_at")
    private Date departureAt;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "container_id", referencedColumnName = "container_id")
    private Container container;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "status_id")
    private TrackingStatus trackingStatus;
}
