package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RideSharingSystem system = RideSharingSystem.getInstance();

        // Register a new user
        System.out.print("Enter your details to register: username, phone number, and email: ");
        String username = scanner.nextLine();
        String phone_number = scanner.nextLine();
        String email = scanner.nextLine();
        User user = new User(username, phone_number, email);
        system.registerUser(user);

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
                    System.out.print("Enter pickup location: ");
                    String requestPickupLocation = scanner.nextLine();
                    System.out.print("Enter drop-off location: ");
                    String requestDropOffLocation = scanner.nextLine();
                    System.out.print("Enter number of seats needed: ");
                    int requestedSeats = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter preferred time: ");
                    String requestPreferredDateTime = scanner.nextLine();

                    // Log the ride request details
                    System.out.println("Ride requested from " + requestPickupLocation + " to " + requestDropOffLocation +
                            " for " + requestedSeats + " seat(s) on " + requestPreferredDateTime);
                    break;

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
                    OfferRide offerRide = new OfferRide(preferredDateTime, availableSeats, price);

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

