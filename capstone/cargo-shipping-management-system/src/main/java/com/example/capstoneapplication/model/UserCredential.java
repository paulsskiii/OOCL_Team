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
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name="user_credentials")
public class UserCredential {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @NonNull
    @Column(name="username", nullable=false, columnDefinition="varchar(255)")
    private String username;

    @NonNull
    @Column(name="password", nullable=false, columnDefinition="varchar(255)")
    private String password;

    @Column(name="isActive", nullable=false)
    private int isActive;

    public UserCredential (String username, String password, int isActive) {
        this.username = username;
        this.password = password;
        this.isActive = isActive;
    }
}
