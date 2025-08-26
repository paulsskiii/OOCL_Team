package com.day15test.testing;

import lombok.Data;

@Data
public class InventoryItem {
    private String name;
    private Integer quantity;

    public InventoryItem(String name, Integer quantity){
        this.name = name;
        this.quantity = quantity;
    }

}
