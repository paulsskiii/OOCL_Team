package com.group1.capstone.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "port")
public class Port {
   @Id
   @Column(name = "port_code", nullable = false, unique = true, length = 10)
   private String portCode;

   @Column(name = "port_location", nullable = false, length = 100)
   private String portLocation;   

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
