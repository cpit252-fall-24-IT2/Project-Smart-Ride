/*
package org.example;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rides")
public class RideController {

    private final RideManager rideManager = RideManager.getInstance();

    @PostMapping("/offer")
    public ResponseEntity<String> offerRide(@RequestBody OfferRide ride) {
        // Assuming you have a way to get the username from the context
        String username = "someUser"; // Replace with actual user retrieval logic
        rideManager.offerRide(username, ride);
        return ResponseEntity.ok("Ride offered successfully");
    }

    @GetMapping("/available")
    public List<OfferRide> getAvailableRides() {
        return rideManager.getAvailableRides();
    }
}
*/