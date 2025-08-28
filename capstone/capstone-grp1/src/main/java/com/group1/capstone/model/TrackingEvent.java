package com.group1.capstone.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tracking_event")
public class TrackingEvent {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @ManyToOne
   @JoinColumn(name = "id", nullable = false)
   private Cargo cargo;

   @ManyToOne
   @JoinColumn(name = "status_id", nullable = false)
   private Status status;
   private LocalDateTime createdAt;
}