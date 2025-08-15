package com.w2g4.w2g4.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @Column(name = "address_id")
    private int address_id; // Primary Key
    
    @Column(name = "address_line1")
    private String address_line1;
    
    @Column(name = "address_line2")
    private String address_line2;

    @Column(name = "barangay")
    private String barangay;

    @ManyToOne
    @JoinColumn (name = "city_id", referencedColumnName = "city_id")
    private City city; // Foreign Key to City Table

    @Column(name = "postal_code")
    private int postal_code;

    @Column(name = "region")
    private String region;

    @Column(name = "country")
    private String country;
}
