package com.group1.capstone.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Cargo")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cargo_id")
    private Long cargo_id;

    @Column(name = "cargo_name") //(name = "cargo_name", nullable = false, length = 100)
    private String cargo_name;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "destination")  //(name = "destination", length = 150)
    private String destination;
}
