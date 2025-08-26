package model;

public class User {
    private String email;
    private String password;
    private boolean isRegistered;
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
    public boolean isRegistered() {
        return isRegistered;
    }
    public void setRegistered(boolean isRegistered) {
        this.isRegistered = isRegistered;
    }
    
}

