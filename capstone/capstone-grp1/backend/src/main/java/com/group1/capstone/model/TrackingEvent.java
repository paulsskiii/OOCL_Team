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
   private Long id;

   @ManyToOne
   @JoinColumn(name = "cargo_id",referencedColumnName = "id", nullable = false)
   private Cargo cargo;

   @ManyToOne
   @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false)
   private Status status;

   @Column(name = "created_at", nullable = false)
   private LocalDateTime createdAt;

   @Column(name = "updated_at", nullable = false)
   private LocalDateTime updatedAt;
}