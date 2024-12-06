package org.example;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

//@Entity
public class OfferRide {
  //  @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
   // private Long id; // Add an ID field

    private String preferredDateTime;
    private int availableSeats;
    private double pricePerSeat;
    private String carType;

    // Constructors, getters and setters


    public OfferRide(Long id, String preferredDateTime, int availableSeats, double pricePerSeat, String carType) {
      //  this.id = id;
        this.preferredDateTime = preferredDateTime;
        this.availableSeats = availableSeats;
        this.pricePerSeat = pricePerSeat;
        this.carType = carType;
    }

    //constructor
    public OfferRide(String preferredDateTime, int availableSeats, double pricePerSeat, String carType) {
        this.preferredDateTime = preferredDateTime;
        this.availableSeats = availableSeats;
        this.pricePerSeat = pricePerSeat;
        this.carType = carType;
    }

    public OfferRide(String preferredDateTime) {
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
        return pricePerSeat;
    }

    public void setPricePerSeat(double pricePerSeat) {

        pricePerSeat = pricePerSeat;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
/*


 */
    }
