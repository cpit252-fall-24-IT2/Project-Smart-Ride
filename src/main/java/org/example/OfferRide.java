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

    public String getPreferredDateTime() {
        return preferredDateTime;
    }

    public void setPreferredDateTime(String preferredDateTime) {
        this.preferredDateTime = preferredDateTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public double getPricePerSeat() {
        return PricePerSeat;
    }

    public void setPricePerSeat(double pricePerSeat) {
        PricePerSeat = pricePerSeat;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
/*
    @Override
    public String toString() {
        return "OfferRide{" +
                ", preferredDateTime='" + preferredDateTime + '\'' +
                ", availableSeats=" + availableSeats +
                ", PricePerSeat=" + PricePerSeat +
                ", carType='" + carType + '\'' +
                '}';
                }

 */
    }
