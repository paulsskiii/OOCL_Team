package day15.excer1_1;

public interface UserRepository {
    User findByEmail(String email);
    User save(User user);
}
