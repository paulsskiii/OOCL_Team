package com.group1.capstone.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cargo")
public class Cargo {

   @Id
   @Column(name = "id", nullable = false)
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name", nullable = false, length = 50)
   private String name;

   @Column(name = "descriptions", length = 254)
   private String descriptions;

   @ManyToOne
   @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false)
   private Status status;

   @ManyToOne
   @JoinColumn(name = "destination", referencedColumnName = "id", nullable = false)
   private Port destination;
   
   @ManyToOne
   @JoinColumn(name = "origin", referencedColumnName = "id", nullable = false)
   private Port origin;

   @ManyToOne
   @JoinColumn(name = "created_by", referencedColumnName = "id", nullable = false)
   private User createdBy;

   @Column(name = "weight", nullable = false)
   private float weight;

   @Column(name = "created_at", nullable = false)
   private LocalDateTime createdAt;

   @Column(name = "updated_at", nullable = false)
   private LocalDateTime updatedAt;

}
