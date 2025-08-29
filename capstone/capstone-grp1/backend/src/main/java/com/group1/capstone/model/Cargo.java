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

   @ManyToOne
   @JoinColumn(name = "status_code", referencedColumnName = "status_code", nullable = false)
   private Status statusCode;

   @ManyToOne
   @JoinColumn(name = "destination", referencedColumnName = "port_code", nullable = false)
   private Port destination;
   
   @ManyToOne
   @JoinColumn(name = "origin", referencedColumnName = "port_code", nullable = false)
   private Port origin;

   @ManyToOne
   @JoinColumn(name = "created_by", referencedColumnName = "id", nullable = false)
   private User createdBy;

   @ManyToOne
   @JoinColumn(name = "consignee", referencedColumnName = "id", nullable = false)
   private User consignee;

   @ManyToOne
   @JoinColumn(name = "courier", referencedColumnName = "id", nullable = false)
   private User courier;

   @Column(name = "created_at", nullable = false)
   private LocalDateTime createdAt;

   @Column(name = "updated_at", nullable = false)
   private LocalDateTime updatedAt;

}
