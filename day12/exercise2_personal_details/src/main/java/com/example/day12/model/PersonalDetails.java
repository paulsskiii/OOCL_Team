package com.example.day12.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name ="personal_details")
public class PersonalDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @Column(name ="firstName")
    private String firstName;

    @Column(name ="middleName")
    private String middleName;

    @Column(name ="lastName")
    private String lastName;   
    
    @Column(name ="occupation")
    private String occupation;

    @Column(name ="email")
    private String email;

    @Column(name ="telephoneNumber")
    private String telNumber;
    
}
