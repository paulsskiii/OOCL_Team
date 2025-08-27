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
    public void setRegistered(boolean isRegistered) {
        this.isRegistered = isRegistered;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public boolean isRegistered() {
        return isRegistered;
    } 



}
