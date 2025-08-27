package com.example.day15;

public class UserRegistrationService {
    private final UserRepository userRepository;
    private final EmailService emailService;
    private final PasswordValidator passwordValidator;

    public UserRegistrationService(UserRepository userRepository, EmailService emailService, PasswordValidator passwordValidator) {
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.passwordValidator = passwordValidator;
    }

    public boolean registerUser(String email, String password) {
        if (!passwordValidator.isValid(password)) {
            return false;
        }
        if (userRepository.findByEmail(email) != null) {
            return false;
        }
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setRegistered(true);
        userRepository.save(newUser);
        emailService.sendRegistrationEmail(email);
        return true;
    }
}
