package org.example;

public class RideSharingSystem {
    private static RideSharingSystem instance;
    private UserRegistry userRegistry;

    private RideSharingSystem() {
        userRegistry = UserRegistry.getInstance();
    }

    public static RideSharingSystem getInstance() {
        if (instance == null) {
            instance = new RideSharingSystem();
        }
        return instance;
    }

    public void registerUser(User user) {
        userRegistry.registerUser(user);
    }

    public User findUserByUsername(String username) {
        return userRegistry.findUserByUsername(username);
    }
}
