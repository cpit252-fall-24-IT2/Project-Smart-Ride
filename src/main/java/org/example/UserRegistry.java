package org.example;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class UserRegistry {
    private static final String usersFile = "users.txt";
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
        File file = new File(usersFile);
        if (!file.exists())
            return;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    User user = new User(parts[0], parts[1], parts[2]);
                    users.put(user.getUsername(), user);
                }
            }
        }
    }

    //save users to file
    private void saveUsersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(usersFile))) {
            for (User user : users.values()) {
                writer.write(user.getUsername() + "," + user.getPhone_number()  + "," + user.getPassword());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }
    private String hashPassword(String password){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password: " + e.getMessage());
        }
    }
        //check for pass validity
    private boolean isPasswordValid(String password) {
        if (password == null | password.length() < 5)
            return false;
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if ("!@#$%^&*()_+-=[]{}|;:,.<>?".indexOf(c) != -1) hasSpecial = true;
        }

        return hasUpper && hasLower && hasDigit && hasSpecial;
    }

    //register a new user with hashed password
    public void registerUser(User user) {
        if (users.containsKey(user.getUsername())) {
            System.out.println("Username already exists. Please try another ");
            return;
        }
        if (!isPasswordValid(user.getPassword())){
            System.out.println("Password does not meet requirement");
            return;
        }
        String hashedPassword = hashPassword(user.getPassword());
        User newUser = new User(user.getUsername(), user.getPhone_number(), hashedPassword);
        users.put(user.getUsername(), newUser);
        saveUsersToFile();
        System.out.println("User registered succesfully. ");
    }


    public void displayAllUsers() {
        if (users.isEmpty()) {
            System.out.println("No users are registered");
        } else {
            users.values().forEach(user -> System.out.println("Username: " + user.getUsername() + "  phone number: "  + user.getPhone_number()));
        }
    }

    public User findUserByUsername(String username) {
        return users.get(username);
    }
    public boolean validateLogin(String username, String password){
        User user = findUserByUsername(username);
            if (user == null) {
                return false;
            }
            String hashedPassword = hashPassword(password);
            return hashedPassword.equals(user.getPassword());
           }

    }
