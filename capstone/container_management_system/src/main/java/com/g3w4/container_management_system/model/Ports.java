package com.g3w4.container_management_system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ports")
public class Ports {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "port_id")
    private int portId;

    @Column(name = "port_name")
    private String portName;
}
