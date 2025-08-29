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
   private int id;

   @Column(name = "name", nullable = false, length = 50)
   private String name;

   @Column(name = "descriptions", length = 254)
   private String descriptions;

   @Column(name = "weight", nullable = false)
   private float weight;

   @JoinColumn(name = "status_code", nullable = false, referencedColumnName = "status_code")
   private String statusCode;

   @JoinColumn(name = "destination", nullable = false, referencedColumnName = "port_code")
   private String destination;
   
   @JoinColumn(name = "origin", nullable = false, referencedColumnName = "port_code")
   private String origin;

   @JoinColumn(name = "created_by", nullable = false, referencedColumnName = "id")
   private int createdBy;

   @JoinColumn(name = "consignee", nullable = false, referencedColumnName = "id")
   private int consignee;

   @JoinColumn(name = "courier", nullable = false, referencedColumnName = "id")
   private int courier;

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
