package com.backend_spring.jdbc_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String firstName;
    String lastName;
    // String contactNumber;
    // String emailAddress;
    // String addressLine1;
    // String addressLine2;
    // String barangay;
    // String city;
    // String postalCode;
    // String region;
    // String country;

}
