package org.example.Strategy;

import org.example.RideManager;
import org.example.OfferRide;
import java.util.List;
import java.util.Scanner;

public class DisplayRidesStrategy implements Strategy {
    private final RideManager rideManager;

    public DisplayRidesStrategy(RideManager rideManager) {
        this.rideManager = rideManager;
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.println("\nAvailable Rides: ");
        List<OfferRide> availableRides = rideManager.getAvailableRides();

        if (availableRides.isEmpty()) {
            System.out.println("No rides available at the moment");
            return;
        }

        for (int i = 0; i < availableRides.size(); i++) {
            OfferRide ride = availableRides.get(i);
            System.out.println((i + 1) + ". " +
                    ride.getPreferredDateTime() + " | Seats: " +
                    ride.getAvailableSeats() + " | Price: " +
                    ride.getPricePerSeat() + " | Car: " +
                    ride.getCarType());
        }

        System.out.println("\nEnter ride number to select, or 0 to go back");
        int selection = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (selection > 0 && selection <= availableRides.size()) {
            System.out.println("You selected " + availableRides.get(selection - 1));
        }
    }
}