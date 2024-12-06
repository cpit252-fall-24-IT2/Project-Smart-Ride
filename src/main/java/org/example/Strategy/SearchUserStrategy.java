package org.example.Strategy;

import org.example.User;
import org.example.UserRegistry;

import java.util.Scanner;

public class SearchUserStrategy implements Strategy {
    private final UserRegistry registry;

    public SearchUserStrategy(UserRegistry registry) {
        this.registry = registry;
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.print("Enter username to search: ");
        String username = scanner.nextLine();
        User user = registry.findUserByUsername(username);
        if (user != null) {
            System.out.println("User found: " + user.getUsername());
        } else {
            System.out.println("User not found.");
        }
    }
}
