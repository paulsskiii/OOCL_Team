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
@Table(name = "cargo")
public class Cargo {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @Column(name = "descriptions",length = 254)
   private String descriptions;

   @ManyToOne
   @JoinColumn(name = "status_id", nullable = false)
   private Status status;

   @ManyToOne
   @JoinColumn(name = "destination", nullable = false)
   private Port destination;

   @ManyToOne
   @JoinColumn(name = "origin", nullable = false)
   private Port origin;

   @ManyToOne
   @JoinColumn(name = "created_by", nullable = false)
   private User createdBy;

   @Column(name = "weight", nullable = false)
   private float weight;

   @Column(name = "created_at", nullable = false)
   private LocalDateTime createdAt;
   
   @Column(name = "updated_at", nullable = false)
   private LocalDateTime updatedAt;
}