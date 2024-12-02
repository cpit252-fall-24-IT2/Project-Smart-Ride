package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RideDAO {
    private Connection connection;

    public RideDAO(Connection connection) {
        this.connection = connection;
    }

    public void addRide(String rideId, String driverId, String origin, String destination, String departureTime, int seatsAvailable) throws SQLException {
        String sql = "INSERT INTO Users (username, email, phone)VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, rideId);
            preparedStatement.setString(2, driverId);
            preparedStatement.setString(4, origin);
            preparedStatement.setString(4, destination);
            preparedStatement.setString(5, departureTime);
            preparedStatement.setInt(6, seatsAvailable);
            preparedStatement.execute();
            System.out.println("User added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ResultSet getAvailableRides() {
        String sql = "SELECT * FROM Rides  WHERE status = 'AVAILABLE'";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            return preparedStatement.executeQuery();  //or maybe we need to add executeQuery(ride)??
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
