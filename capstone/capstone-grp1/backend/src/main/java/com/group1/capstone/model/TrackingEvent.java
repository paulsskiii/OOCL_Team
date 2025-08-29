package com.group1.capstone.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

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
   private Timestamp createdAt;

   @Column(name = "updated_at", nullable = false)
   private Timestamp updatedAt;
   
   @PrePersist
   protected void onCreate() {
      Timestamp now = new Timestamp(System.currentTimeMillis());
      createdAt = now;
      updatedAt = now;
   }

   @PreUpdate
   protected void onUpdate() {
      updatedAt = new Timestamp(System.currentTimeMillis());
   }
}