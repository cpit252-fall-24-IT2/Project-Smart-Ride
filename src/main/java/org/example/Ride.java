package org.example;

import java.util.Date;

public class Ride {
    private User passenger;
    private User driver;
    private String pickupLocation;
    private String dropoffLocation;
    private Date dateTime;
    private boolean completed;

    //constructor
    public Ride(User passenger, String dropoffLocation){
        this.passenger = passenger;
    }

    public Ride(User passenger) {
    }


    public void setPassenger(User passenger) {
        this.passenger = passenger;
    }

    public User getPassenger() {
        return passenger;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public User getDriver() {
        return driver;
    }

    public void setPickupLocation(String location) {
        this.pickupLocation = location;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setDropoffLocation(String location) {
        this.dropoffLocation = location;
    }

    public String getDropoffLocation() {
        return dropoffLocation;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void completeRide() {
        this.completed = true;
    }
}
