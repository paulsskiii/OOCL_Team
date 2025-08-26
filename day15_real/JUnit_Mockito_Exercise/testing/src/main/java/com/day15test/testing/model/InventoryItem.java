package com.day15test.testing.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class InventoryItem {
    @Id
    private String name;
    private double price;

    public InventoryItem (String name, double price) {}
}
