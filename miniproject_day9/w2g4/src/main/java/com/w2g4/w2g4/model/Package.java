package com.w2g4.w2g4.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Package")
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "package_id")
    private int packageId;

    @Column(name = "pickup_date")
    private Timestamp pickUpDate;

    @Column(name = "delivery_date")
    private Timestamp deliveryDate;

    @Column(name = "package_type_id")
    private int packageTypeId;

    @Column(name = "weight")
    private double weight;

    @Column(name = "contents_description")
    private String contentsDescription;

    @Column(name = "sender_id")
    private int senderId;

    @Column(name = "recipient_id")
    private int recipientId;

    @Column(name = "courier_id")
    private int courierId;

    @Column(name = "created_at")
    private Timestamp createdAt;
}