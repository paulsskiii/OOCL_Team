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
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="containers")
public class Container {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @NonNull
    @Column(name ="name", nullable=false, columnDefinition="varchar(255)")
    private String name;
    
    @Column(name ="origin", columnDefinition="char(5)")
    private String origin;

    @Column(name ="destination", columnDefinition="char(5)")
    private String destination;

    @Column(name ="status", columnDefinition="char(2)")
    private String status;

    @Column(name ="weight")
    private double weight; // in kg

    @Column(name ="departure_date", columnDefinition="datetime")
    private String departureDate;

    @Column(name ="arrival_date", columnDefinition="datetime")
    private String arrivalDate;

    @Column(name ="booked_by", nullable=false)
    @NonNull
    private Long bookedBy;

    public Container (String name, String origin, String destination, String status, double weight, String departureDate, String arrivalDate, Long bookedBy) {
        this.name = name;
        this.origin = origin;
        this.destination = destination;
        this.status = status;
        this.weight = weight;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.bookedBy = bookedBy;
    }
}
