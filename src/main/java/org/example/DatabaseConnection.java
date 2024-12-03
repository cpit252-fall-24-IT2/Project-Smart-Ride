package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DB_URL = "jdc:sqlite:ridesharing.db";
    private static Connection connection;

    //constructor
    private DatabaseConnection() {
    }

    public static Connection getConnecection(){
        if (connection == null){
            try {
                connection = DriverManager.getConnection(DB_URL);
                System.out.println("Database Connected ");
            }catch (SQLException e)  {
                throw new RuntimeException("Connection to the Database failed", e);

            }
        }
        return connection;
    }

}
