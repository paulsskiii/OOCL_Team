package com.w2g4.w2g4.model;

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
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long address_id; // Primary Key
    private String address_line1;
    private String address_line2;
    private String barangay;
    private City city; // Foreign Key to City Table
    private Integer postal_code;
    private String region;
    private String country;
}
