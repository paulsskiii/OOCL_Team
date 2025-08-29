package com.g3w4.container_management_system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "container")
public class Container {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "container_id")
    private int containerId;

    @Column(name = "container_name")
    private String containerName;

    @Column(name = "weight")
    private double weight;

    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "customer_id")
    private Customer senderId;

    @ManyToOne
    @JoinColumn(name = "receiver_id", referencedColumnName = "customer_id")
    private Customer receiverId;

    @ManyToOne
    @JoinColumn(name = "origin_id", referencedColumnName = "port_id")
    private Ports originId;

    @ManyToOne
    @JoinColumn(name = "destination_id", referencedColumnName = "port_id")
    private Ports destinationId;
}
