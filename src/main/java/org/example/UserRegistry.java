package org.example;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserRegistry {
    private static UserRegistry instance;
    private Map<String, User> users = new HashMap<>();


    //singleton using synch block 4 thread safety
    public static synchronized UserRegistry getInstance() {
        if (instance == null) {
            instance = new UserRegistry();
        }
        return instance;
    }

    //b4 adding a user check if username is taken
    public boolean isUsernameTaken(String username) {
        return users.containsKey(username);
    }

    public void registerUser(User user) {
        if (user == null || user.getUsername() == null || user.getUsername().isEmpty()) {
            System.out.println("Invalid user details. Registration failed.");
            return;
        }
        if (isUsernameTaken(user.getUsername())) {
            System.out.println("Username \"" + user.getUsername() + "\" is already taken. Please choose another one.");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Enter a new username: ");
                String newUsername = scanner.nextLine();
                if (!isUsernameTaken(newUsername)) {
                    user.setUsername(newUsername);
                    break;
                }
                System.out.println("Username \"" + newUsername + "\" is also taken. Try again.");
            }
        }
        users.put(user.getUsername(), user);
        System.out.println("User registered successfully with username: " + user.getUsername());
    }


        //Find a user by username
        public User findUserByUsername(String username) {
            User user = users.get(username);
            if (user == null) System.out.println("User not found for username: " + username);
            return user;
        }

}


