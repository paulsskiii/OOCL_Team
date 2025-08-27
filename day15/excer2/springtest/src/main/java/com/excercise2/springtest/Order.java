package com.excercise2.springtest;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data 
public class Order {
    private Long id;
    private String name;
    private double price;
    private String status;
    public Order(long l, String string, double d, String string2) {
        //TODO Auto-generated constructor stub
    }

    public Order(String string, double d) {
        //TODO Auto-generated constructor stub
    }
}
