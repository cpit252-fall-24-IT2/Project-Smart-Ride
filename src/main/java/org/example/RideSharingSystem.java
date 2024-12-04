package org.example;

public class RideSharingSystem {
    private static RideSharingSystem instance;
    private UserRegistry userRegistry;

    //constructor
    private RideSharingSystem() {
        userRegistry = UserRegistry.getInstance();
    }

    public static synchronized RideSharingSystem getInstance() {
        if (instance == null) {
            instance = new RideSharingSystem();
        }
        return instance;
    }


     public User findUserByUsername(String username){
        return  userRegistry.findUserByUsername(username);
    }

    //check if thers is atleast 1 passenger and create a ride
    public Ride createRide(User passenger) {
        try {
            if (passenger == null) {
                throw new IllegalArgumentException("Passenger cannot be null.");
            }
            return new Ride(passenger);
        } catch (Exception e){
            System.out.println("Failed to create ride" + e.getMessage());
            return null;
    }
        }
    }

