package com.w2g4.w2g4.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Courier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courier_id;
    private String first_name;
    private String last_name;
    private String contact_number;
    private String vehicle_type;
    private String license_number;
    private String created_at;
}












