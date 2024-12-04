package org.example;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import org.example.Map.WaypointSelector;
import org.example.Map.MyWaypoint;
import javax.swing.*;

public class Main {
public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    UserRegistry registry = UserRegistry.getInstance();
    RideManager  rideManager = RideManager.getInstance();
    System.out.println("\n Welcome to Ride Sharing APP\n What would you like to do?");

    boolean exit = false;
    while (!exit) {
        System.out.println("\n1. Register/LogIN ");
        System.out.println("2. Display All Users");
        System.out.println("3. Search User by Username");
        System.out.println("4. Request a Ride");
        System.out.println("5. Offer a Ride");
        System.out.println("6. Display available Rides");
        System.out.println("7. Quit");
        System.out.print("Enter your choice (1-7): ");

        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            // Register a new user
            case 1: {
                System.out.println("Enter your details to register:");
                System.out.println("Enter a username");
                String username = scanner.nextLine();
                System.out.println("Enter a phone number");
                String phone_number = scanner.nextLine();
                System.out.println("Enter a password: it should be atleast 5 characters, and include atleast 1 Upper Letter, 1 Lower Letter, 1 Digit and 1 special character:: ");
                String password = scanner.nextLine();
                User user = new User(username, phone_number, password);
                registry.registerUser(user);
                break;
            }
            //dispaly users
                  case 2: {
                      registry.displayAllUsers();
                      break;

                  }
            case 3: {
                System.out.println("Enter username to search: ");
                String username = scanner.nextLine();
                User user = registry.findUserByUsername(username);
                if (user != null) {
                    System.out.println("User found: " + user.getUsername() );
                } else {
                    System.out.println("User not found.");
                }
                break;
            }
            
            case 4: {
                // Request a ride
                System.out.println("Request a Ride:");
                WaypointSelector selector = new WaypointSelector("Enter Pick-up Location: ");

                MyWaypoint requestPickupLocation = selector.getWaypoint("Star");
                System.out.println(requestPickupLocation);

                selector = new WaypointSelector("Enter drop-off location: ");

                MyWaypoint requestDropOffLocation = selector.getWaypoint("End");
                System.out.println(requestDropOffLocation);


                    System.out.print("Enter number of seats needed: ");
                    int requestedSeats = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter preferred time: ");
                    String requestPreferredDateTime = scanner.nextLine();

                    // Log the ride request details
                System.out.println("Ride requested from " + requestPickupLocation + " to " + requestDropOffLocation +
                                " for " + requestedSeats + " seat(s) on " + requestPreferredDateTime);
                break;
            }

                case 5:
                    // Offer a ride
                   try {
                       System.out.println("Offer a Ride:");
                       System.out.println("Enter your Username");
                       String offererUsername = scanner.nextLine();
                       System.out.print("Enter preferred time: ");
                       String preferredDateTime = scanner.nextLine();
                       System.out.print("Enter available seats: ");
                       int availableSeats = scanner.nextInt();
                       System.out.print("Enter price per seat: ");
                       double price = scanner.nextDouble();
                       scanner.nextLine();
                       System.out.print("Enter type of car: ");
                       String carType = scanner.nextLine();

                       // Create an OfferRide object for the driver
                       OfferRide offerRide = new OfferRide(preferredDateTime, availableSeats, price, carType);
                       rideManager.offerRide(offererUsername, offerRide);
                       System.out.println("Ride offered successfully " + offerRide);
                   } catch (Exception e) {
                       System.out.println("Error offering Ride: " + e.getMessage());
                   }
                    break;
            case 6:{
                System.out.println("\nAvailable Rides: ");
                List<OfferRide> availableRides = RideManager.getInstance().getAvailableRides();
                if (availableRides.isEmpty()){
                    System.out.println("No rides available at the moment ");
                } else {
                    for (int i = 0; i < availableRides.size(); i++) {
                        System.out.println((i + 1) + ". " + availableRides.get(i).getPreferredDateTime() + " | Seats: " + availableRides.get(i).getAvailableSeats() + " | Price: " + availableRides.get(i).getPricePerSeat() + " | Car: " + availableRides.get(i).getCarType());
                    }
                    System.out.println("\nEnter ride number to select, or 0 to go back ");
                    int selection = scanner.nextInt();
                    scanner.nextLine();
                    if (selection > 0 && selection <= availableRides.size()) {
                        System.out.println("Your selected  " + availableRides.get(selection - 1));
                    }
                }
                break;
            }

                case 7:
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


