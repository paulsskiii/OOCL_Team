package com.group1.capstone.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Data
@Entity
@Table(name = "user")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
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

   @JoinColumn(name = "role", referencedColumnName = "name", nullable = false)
   @JsonIdentityReference(alwaysAsId = true)
   private String role;

   @Column(name = "password", nullable = false, length = 50)
   private String password;

   @Column(name = "contact_number", nullable = false, unique = true, length = 16)
   private String contactNumber;

   @Column(name = "created_at", nullable = false)
   private LocalDateTime createdAt;

   @Column(name = "updated_at", nullable = false)
   private LocalDateTime updatedAt;

}