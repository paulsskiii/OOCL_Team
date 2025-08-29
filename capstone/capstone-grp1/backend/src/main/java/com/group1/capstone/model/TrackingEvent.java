package com.group1.capstone.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Data
@Entity
@Table(name = "tracking_event")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class TrackingEvent {
   @Id
   @Column(name = "id", nullable = false)
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @ManyToOne
   @JoinColumn(name = "cargo_id",referencedColumnName = "id", nullable = false)
   @JsonIdentityReference(alwaysAsId = true)
   private Cargo cargoId;

   @ManyToOne
   @JoinColumn(name = "status_code", referencedColumnName = "status_code", nullable = false)
   @JsonIdentityReference(alwaysAsId = true)
   private Status statusCode;

   @Column(name = "created_at", nullable = false)
   private LocalDateTime createdAt;

   @Column(name = "updated_at", nullable = false)
   private LocalDateTime updatedAt;
}