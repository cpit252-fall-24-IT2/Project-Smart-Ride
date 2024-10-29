package org.example;


import java.util.HashMap;
import java.util.Map;

public class UserRegistry {
    private static UserRegistry instance;
    private Map<String, User> users;

    private UserRegistry() {
        users = new HashMap<>();
    }

    public static UserRegistry getInstance() {
        if (instance == null) {
            instance = new UserRegistry();
        }
        return instance;
    }

    public void registerUser(User user) {
        users.put(user.getUsername(), user);
    }

    public User findUserByUsername(String username) {
        return users.get(username);
    }
}

