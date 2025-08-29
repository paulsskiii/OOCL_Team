package com.group1.capstone.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Data
@Entity
@Table(name = "port")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "portCode")
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
}
