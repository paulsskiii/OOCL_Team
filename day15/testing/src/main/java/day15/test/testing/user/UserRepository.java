package day15.test.testing.user;

public interface UserRepository {
    User findByEmail(String email);
    User save(User user);
}
