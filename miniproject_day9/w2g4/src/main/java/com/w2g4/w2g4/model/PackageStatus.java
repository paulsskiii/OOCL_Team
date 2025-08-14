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
public class PackageStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int packageStatusId;
    private String statusName;
}