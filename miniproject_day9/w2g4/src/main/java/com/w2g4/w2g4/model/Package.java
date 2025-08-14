package com.w2g4.w2g4.model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int packageId;
    private Timestamp pickUpDate;
    private Timestamp deliveryDate;
    private int packageTypeId;
    private double weight;
    private String contentsDescription;
    private int senderId;
    private int recipientId;
    private int courierId;
    private Timestamp createdAt;
}