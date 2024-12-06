package org.example;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.*;
import com.google.gson.Gson;

import java.net.HttpURLConnection;



public class RideManager {
    private static final String RIDES_FILE = "rides.txt";
    private static RideManager instance;
    private final List<OfferRide> availableRides = new ArrayList<>();
    private final Map<String, List<OfferRide>> userRides = new HashMap<>();
    //server
    private static final String SERVER_URL = "api";
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
                    OfferRide ride = new OfferRide("preferred time:" + dateTime + ",available seats: " + seats +",price per seat" + price + ",car type:" + carType);
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
        postRideToServer(username, ride);
    }

    private void postRideToServer(String username, OfferRide ride) {
        Gson gson = new Gson();
        try {
            URL url = new URL(SERVER_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Create JSON representation of the ride
            String jsonInputString =  gson.toJson(new RideRequest(username, ride));

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            // Check the response code
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Ride posted successfully to the server.");
            } else if (responseCode == HttpURLConnection.HTTP_BAD_REQUEST) {
                System.out.println("Bad request: Please check the ride details.");
            } else {
                System.out.println("Failed to post ride: " + conn.getResponseMessage());
            }

        } catch (IOException e) {
            System.out.println("Error posting ride to server: " + e.getMessage());
        }
    }
    // Class to represent the JSON structure
    private class RideRequest {
        String username;
        OfferRide ride;

        RideRequest(String username, OfferRide ride) {
            this.username = username;
            this.ride = ride;
        }
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


