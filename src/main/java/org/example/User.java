package org.example;

public class User {
    private String username;
    private String phone_number;
    private String email;
    private double balance;


    //constructor
    public User(String username, String phone_number, String email) {
        this.username = username;
        this.phone_number = phone_number;
        this.email = email;
        this.balance = 0.0;
    }

    //getters and setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                '}';
    }
}





