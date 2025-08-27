package day15.test.testing.user;

import lombok.Data;

@Data
public class User {
    private String email;
    private String password;
    private boolean isRegistered;
}
