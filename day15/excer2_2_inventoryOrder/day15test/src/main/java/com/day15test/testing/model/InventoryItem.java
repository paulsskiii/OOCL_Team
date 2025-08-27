package com.day15test.testing.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class InventoryItem {

    @Id
    private long id;
    private String name;
    private Double quantity;

    // public InventoryItem(String name, Double quantity){
    //     this.name = name;
    //     this.quantity = quantity;
    // }

}
