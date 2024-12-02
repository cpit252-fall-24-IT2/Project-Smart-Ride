package org.example;

import java.io.*;
import java.util.*;

public class UserRegistry {
    private static final String FILE_NAME = "users.txt";

    private static UserRegistry instance;
    private final Map<String, User> users = new HashMap<>();

    private UserRegistry() {
        try {
            loadUsersFromFile();
        } catch (IOException e) {
            System.out.println("Error loading Users " + e.getMessage());
        }
    }

    //singleton using synch block 4 thread safety
    public static synchronized UserRegistry getInstance() {
        if (instance == null) {
            instance = new UserRegistry();
        }
        return instance;
    }

    //load users from file
    private void loadUsersFromFile() throws IOException {
        File file = new File(FILE_NAME);
        if (!file.exists())
            return;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    User user = new User(parts[0], parts[1], parts[2], parts[3]);
                    users.put(user.getUsername(), user);
                }
            }
        }
    }

    //save users to file
    private void saveUsersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (User user : users.values()) {
                writer.write(user.getUsername() + "," + user.getPhone_number() + "," + user.getEmail() + "," + user.getPassword());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }

    public void registerUser(User user) {
        if (users.containsKey(user.getUsername())) {
            System.out.println("Username already exists. Please try another ");
            return;
        }
        users.put(user.getUsername(), user);
        saveUsersToFile();
        System.out.println("User registered succesfully. ");
    }

    public void displayAllUsers() {
        if (users.isEmpty()) {
            System.out.println("No users are registered");
        } else {
            users.values().forEach(user -> System.out.println("Username:" + user.getUsername() + ", Email: " + user.getEmail() + user.getPhone_number()));
        }
    }

    public User findUserByUsername(String username) {
        return users.get(username);
    }
}