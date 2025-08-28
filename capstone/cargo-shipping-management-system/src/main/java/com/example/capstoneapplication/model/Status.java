package com.example.capstoneapplication.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="status")
public class Status {
    @Id
    @Column(name="id", columnDefinition="char(2)")
    private String id;

    @Column(name="name", nullable=false, columnDefinition="varchar(255)")
    private String name;
}
