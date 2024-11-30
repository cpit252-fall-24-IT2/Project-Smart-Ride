package org.example;


import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String phone_number;
    private String email;
    private String password ;
    private double balance;


    public User(String username, String phone_number, String email, String password) {
        this.username = username;
        this.phone_number = phone_number;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {

        this.balance = balance;
    }


}





