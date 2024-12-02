package org.example;


import org.example.Map.Map;
import org.example.Map.MyWaypoint;
import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RideSharingSystem system = RideSharingSystem.getInstance();

        // Register a new user
        System.out.println("Enter your details to register:");
        System.out.println("Enter a username");
        String username =  scanner.nextLine();
        System.out.println("Enter a phone number");
        String phone_number = scanner.nextLine();
        System.out.println("Enter an email");
        String email = scanner.nextLine();
        User user = new User(username, phone_number, email);
        system.registerUser(user);
        System.out.println("Your account with the following details is created successfully: " + user);

        boolean exit = false;
        while (!exit) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Request a Ride");
            System.out.println("2. Offer a Ride");
            System.out.println("3. Quit");
            System.out.print("Enter your choice (1-3): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Request a ride
                    System.out.println("Request a Ride:");
                        Map map = new Map();
                        map.createMapViewer();

                        JFrame frem = map.setupWindow("Enter pickup location: ");
                        MyWaypoint requestPickupLocation = map.runWaypointCatcher();
                        System.out.println(requestPickupLocation);
                        frem.dispose(); // Close the frame

                        frem = map.setupWindow("Enter drop-off location: ");
                        MyWaypoint requestDropOffLocation = map.runWaypointCatcher();
                        frem.dispose(); // Close the frame

                        System.out.print("Enter number of seats needed: ");
                        int requestedSeats = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter preferred time: ");
                        String requestPreferredDateTime = scanner.nextLine();

                        // Log the ride request details
                        System.out.println("Ride requested from " + requestPickupLocation + " to " + requestDropOffLocation +
                                " for " + requestedSeats + " seat(s) on " + requestPreferredDateTime);

                case 2:
                    // Offer a ride
                    System.out.println("Offer a Ride:");
                    System.out.print("Enter preferred time: ");
                    String preferredDateTime = scanner.nextLine();
                    System.out.print("Enter available seats: ");
                    int availableSeats = scanner.nextInt();
                    System.out.print("Enter price per seat: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter type of car: ");
                    String carType = scanner.nextLine();

                    // Create an OfferRide object for the driver
                    OfferRide offerRide = new OfferRide(preferredDateTime, availableSeats, price, carType);

                    // Log the offered ride details
                    System.out.println("Ride offered: " + offerRide + ", Type of car: " + carType);
                    break;

                case 3:
                    // Quit
                    System.out.println("Thank you for using the Ride Sharing System. Goodbye!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
            }
        }

        scanner.close();
    }
}


