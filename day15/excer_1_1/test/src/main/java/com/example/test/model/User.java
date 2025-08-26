package com.example.test.model;

public class User {
    private String email;
    private String password;
    private boolean isRegistered;

    // Getters and setters
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRegistered(Boolean isRegistered) {
        this.isRegistered = isRegistered;
    }
}

