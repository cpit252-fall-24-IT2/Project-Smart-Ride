package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideManager {
    private static final String RIDES_FILE = "rides.txt";
    private static RideManager instance;
    private final List<OfferRide> availableRides = new ArrayList<>();
    private final Map<String, List<OfferRide>> userRides = new HashMap<>();

    private RideManager() throws IOException {
        loadRidesFromFile();
    }

    public static synchronized RideManager getInstance() throws IOException {
        if (instance == null) {
            instance = new RideManager();
        }
        return instance;
    }

    private void loadRidesFromFile() throws IOException {
        File file = new File(RIDES_FILE);
        if (!file.exists()) {
            System.out.println("Rides file not found. ");
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String username = parts[0];
                    String dateTime = parts[1];
                    int seats = Integer.parseInt(parts[2]);
                    double price = Double.parseDouble(parts[3]);
                    String carType = parts[4];
                    OfferRide ride = new OfferRide(dateTime, seats, price, carType);
                    availableRides.add(ride);
                    userRides.computeIfAbsent(username, k -> new ArrayList<>()).add(ride);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading rides: " + e.getMessage());
            // Add to user rides
            //if (!userRides.containsKey(username)) {
            //  userRides.put(username, new ArrayList<>());
            // }
            // userRides.get(username).add(ride);
        }
    }

    private void saveRidesToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RIDES_FILE))) {
            for (Map.Entry<String, List<OfferRide>> entry : userRides.entrySet()) {
                String username = entry.getKey();
                for (OfferRide ride : entry.getValue()) {
                    writer.write(String.format("%s,%s,%d,%.2f,%s",
                            username,
                            ride.getPreferredDateTime(),
                            ride.getAvailableSeats(),
                            ride.getPricePerSeat(),
                            ride.getCarType()));
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving rides: " + e.getMessage());
        }
    }
                  //  OfferRide newRide = new OfferRide(ride.getPreferredDateTime(), ride.getAvailableSeats(), ride.getPricePerSeat(),ride.getCarType());
              //      saveRidesToFile();
                //    System.out.println("User registered succesfully. ");

    public void offerRide(String username, OfferRide ride) {
        availableRides.add(ride);
        userRides.computeIfAbsent(username, k -> new ArrayList<>()).add(ride);
        saveRidesToFile();
    }
       // availableRides.add(ride);
        //if (!userRides.containsKey(username)) {
         //   userRides.put(username, new ArrayList<>());
        ///}
       // userRides.get(username).add(ride);
       // saveRidesToFile();

    public List<OfferRide> getAvailableRides() {
        return new ArrayList<>(availableRides);
    }

    public List<OfferRide> getUserRides(String username) {
        return userRides.getOrDefault(username, new ArrayList<>());
    }

    }


