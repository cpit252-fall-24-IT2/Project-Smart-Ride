package org.example.Strategy;

import org.example.UserRegistry;
import org.example.User;
import java.util.Scanner;

public class RegisterStrategy implements Strategy {
    private final UserRegistry registry;

    public RegisterStrategy(UserRegistry registry) {
        this.registry = registry;
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.println("Enter your details to register:");

        System.out.println("Enter a username");
        String username = scanner.nextLine();

        System.out.println("Enter a phone number");
        String phoneNumber = scanner.nextLine();

        System.out.println("Enter a password: it should be at least 5 characters, and include at least 1 Upper Letter, 1 Lower Letter, 1 Digit and 1 special character:");
        String password = scanner.nextLine();

        User user = new User(username, phoneNumber, password);
        registry.registerUser(user);
    }
}