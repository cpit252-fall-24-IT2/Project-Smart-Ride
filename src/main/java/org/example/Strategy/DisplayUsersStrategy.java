package org.example.Strategy;

import org.example.UserRegistry;
import java.util.Scanner;

public class DisplayUsersStrategy implements Strategy {
    private final UserRegistry registry;

    public DisplayUsersStrategy(UserRegistry registry) {
        this.registry = registry;
    }

    @Override
    public void execute(Scanner scanner) {
        registry.displayAllUsers();
    }
}