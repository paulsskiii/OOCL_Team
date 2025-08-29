package com.g3w4.container_management_system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
    private long containerId;

    @Column(name = "container_name")
    private String containerName;

    @Column(name = "weight")
    private double weight;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    @Column(name = "sender_id")
    private Customer senderId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    @Column(name = "receiver_id")
    private Customer receiverId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "port_id")
    @Column(name = "origin_id")
    private Ports originId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "port_id")
    @Column(name = "destination_id")
    private Ports destinationId;
}
