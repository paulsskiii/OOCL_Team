package com.group1.capstone.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "tracking_event")
public class TrackingEvent {
   @Id
   @Column(name = "id", nullable = false)
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @JoinColumn(name = "cargo_id",referencedColumnName = "id", nullable = false)
   private int cargoId;

   @JoinColumn(name = "status_code", referencedColumnName = "status_code", nullable = false)
   private String statusCode;

   @Column(name = "created_at", nullable = false)
   private LocalDateTime createdAt;

   @Column(name = "updated_at", nullable = false)
   private LocalDateTime updatedAt;

   @PrePersist
   protected void onCreate() {
      createdAt = LocalDateTime.now();
      updatedAt = LocalDateTime.now();
   }

   @PreUpdate
   protected void onUpdate() {
      updatedAt = LocalDateTime.now();
   }
}