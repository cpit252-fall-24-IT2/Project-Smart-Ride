package org.example;

import org.example.Map.MyWaypoint;

import java.util.Date;

public class Ride {
    private User passenger;
    private User driver;
    private MyWaypoint pickupLocation;
    private MyWaypoint dropoffLocation;
    private Date dateTime;
    private boolean completed;

    //constructor
    public Ride(User passenger, MyWaypoint dropoffLocation){
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

    public void setPickupLocation(MyWaypoint location) {
        this.pickupLocation = location;
    }

    public MyWaypoint getPickupLocation() {
        return pickupLocation;
    }

    public void setDropoffLocation(MyWaypoint location) {
        this.dropoffLocation = location;
    }

    public MyWaypoint getDropoffLocation() {
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
