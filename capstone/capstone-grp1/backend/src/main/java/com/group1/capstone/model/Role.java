package com.group1.capstone.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "name", length = 20, nullable = false)
    private String name;

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



