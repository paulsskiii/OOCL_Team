package com.example.testexercise.model;

public class Order {
    private Long id;
    private String item;
    private Double price;
    private String status;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    

    // Constructors, getters, and setters
    public Order(Long id, String item, Double price, String status) {
        this.id = id;
        this.item = item;
        this.price = price;
        this.status = status;
    }
    public Order() {
    }
    

}