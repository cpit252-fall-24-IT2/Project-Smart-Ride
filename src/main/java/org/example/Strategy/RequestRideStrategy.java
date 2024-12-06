package org.example.Strategy;

import org.example.RideManager;
import org.example.Map.WaypointSelector;
import org.example.Map.MyWaypoint;
import java.util.Scanner;

public class RequestRideStrategy implements Strategy {
    private final RideManager rideManager;

    public RequestRideStrategy(RideManager rideManager) {
        this.rideManager = rideManager;
    }

    @Override
    public void execute(Scanner scanner) {
        try {
            System.out.println("Request a Ride:");
            WaypointSelector selector = new WaypointSelector("Enter Pick-up Location: ");
            MyWaypoint requestPickupLocation = selector.getWaypoint("Star");
            System.out.println(requestPickupLocation);

            selector = new WaypointSelector("Enter drop-off location: ");
            MyWaypoint requestDropOffLocation = selector.getWaypoint("End");
            System.out.println(requestDropOffLocation);

            System.out.print("Enter number of seats needed: ");
            int requestedSeats = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter preferred time: ");
            String requestPreferredDateTime = scanner.nextLine();

            System.out.println("Ride requested from " + requestPickupLocation +
                    " to " + requestDropOffLocation +
                    " for " + requestedSeats + " seat(s) on " +
                    requestPreferredDateTime);
        } catch (Exception e) {
            System.out.println("Error requesting ride: " + e.getMessage());
        }
    }
}