package org.example;

public class OfferRide {
    private String preferredDateTime;
    private int availableSeats;
    private double PricePerSeat;
    private String carType;

    //constructor
    public OfferRide(String preferredDateTime, int availableSeats, double pricePerSeat, String carType) {
        this.preferredDateTime = preferredDateTime;
        this.availableSeats = availableSeats;
        PricePerSeat = pricePerSeat;
        this.carType = carType;
    }

    @Override
    public String toString() {
        return "OfferRide{" +
                ", preferredDateTime='" + preferredDateTime + '\'' +
                ", availableSeats=" + availableSeats +
                ", PricePerSeat=" + PricePerSeat +
                ", carType='" + carType + '\'' +
                '}';
    }
}