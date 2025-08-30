package com.group1.capstone.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "user")
public class User {
   @Id
   @Column(name = "id", nullable = false)
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @Column(name = "first_name", nullable = false, length = 50)
   private String firstName;

   @Column(name = "last_name", nullable = false, length = 50)
   private String lastName;

   @Column(name = "username", nullable = false, unique = true, length = 50)
   private String username;

   @Column(name = "email", nullable = false, unique = true, length = 50)
   private String email;

   @Column(name = "role", nullable = false)
   private String role;

   @Column(name = "password", nullable = false, length = 50)
   private String password;

   @Column(name = "contact_number", nullable = false, unique = true, length = 16)
   private String contactNumber;

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