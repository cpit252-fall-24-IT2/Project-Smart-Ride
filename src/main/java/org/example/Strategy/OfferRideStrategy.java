package org.example.Strategy;

import org.example.RideManager;
import org.example.OfferRide;
import java.util.Scanner;

public class OfferRideStrategy implements Strategy {
    private final RideManager rideManager;

    public OfferRideStrategy(RideManager rideManager) {
        this.rideManager = rideManager;
    }

    @Override
    public void execute(Scanner scanner) {
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
            scanner.nextLine(); // Consume newline

            System.out.print("Enter type of car: ");
            String carType = scanner.nextLine();

            OfferRide offerRide = new OfferRide(preferredDateTime, availableSeats, price, carType);
            rideManager.offerRide(offererUsername, offerRide);
            System.out.println("Ride offered successfully " + offerRide);
        } catch (Exception e) {
            System.out.println("Error offering ride: " + e.getMessage());
        }
    }
}