package com.group1.capstone.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

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

   @JoinColumn(name = "shipper", nullable = false, referencedColumnName = "id")
   private int createdBy;

   @JoinColumn(name = "consignee", nullable = false, referencedColumnName = "id")
   private int consignee;

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
