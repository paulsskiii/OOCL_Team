package com.group1.capstone.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "status")
public class Status {
   @Id
   @Column(name = "status_code", nullable = false, unique = true, length = 5)
   private String statusCode;

   @Column(name = "status_type", nullable = false, length = 100)
   private String statusType;   

   @Column(name = "created_at", nullable = false)
   private LocalDateTime createdAt;

   @Column(name = "updated_at", nullable = false)
   private LocalDateTime updatedAt;

}

