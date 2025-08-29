package com.group1.capstone.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;


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
