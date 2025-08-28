package com.example.capstoneapplication.model;

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
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user_information")
public class UserInformation {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="email", nullable=false, columnDefinition="varchar(255)")
    private String email;

    @Column(name="contact_number", nullable=false, columnDefinition="varchar(63)")
    private String contactNumber;

    @Column(name="user_credentials_id", nullable=false)
    private Long userCredentialsId;

    public UserInformation (String email, String contactNumber, Long userCredentialsId) {
        this.email = email;
        this.contactNumber = contactNumber;
        this.userCredentialsId = userCredentialsId;
    }
}