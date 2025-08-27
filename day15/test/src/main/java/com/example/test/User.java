package com.example.test;

public class User {
    private String email;
    private String password;
    private boolean isRegistered;
    private String orders;
    // Getters and setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsRegistered() {
        return isRegistered;
    }

    public void setIsRegistered(boolean isRegistered) {
        this.isRegistered = isRegistered;
    }

    public String getOrders(){
        return orders;
    }

    public void setOrders(String orders){
        this.orders = orders;
    }

}
