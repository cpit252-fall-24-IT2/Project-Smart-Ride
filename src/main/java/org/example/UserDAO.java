package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
public class UserDAO {
     private Connection connection;

     public UserDAO(Connection connection) throws SQLException {
         this.connection = connection;
     }

     public  void addUser(String username, String email, String phone ) throws SQLException {
         String sql = "INSERT INTO Users (username, email, phone)VALUES (?, ?, ?)";
     try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            preparedStatement.setString(4, phone);
            preparedStatement.execute();
            System.out.println("User added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
     }
     }


    public ResultSet getAllUsers(){
    String sql = "SELECT * FROM Users" ;
   try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
    return preparedStatement.executeQuery();
 } catch (SQLException e) {
    e.printStackTrace();
}
return null;
}
}