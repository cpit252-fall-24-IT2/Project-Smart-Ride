package org.example;

<<<<<<< Updated upstream
public class RideSharingFacade {
    private RideSharingSystem rideSharingSystem;
    private UserRegistry userRegistry;

    public RideSharingFacade() {
        rideSharingSystem = RideSharingSystem.getInstance();
        userRegistry = UserRegistry.getInstance();
    }

    public User registerUser(String username, String phone_number, String email) {
        User user = new User(username,phone_number,email);

        if (userRegistry.isUsernameTaken(user.getUsername())) {
            System.out.println("Username \"" + username + "\" is already taken. Registration failed.");
            return null;
        }
        rideSharingSystem.registerUser(user);
        System.out.println("user register succesfully with username" + username);
        return  user;
    }

    public Ride requestRide(String username){
        User user = rideSharingSystem.findUserByUsername(username);
        if (user != null) {
            return rideSharingSystem.createRide(user);
        }
        System.out.println("User not found for username: " + username);
        return null;
    }

    public void offerRide(String username, String route, int seats){
        User user = rideSharingSystem.findUserByUsername(username);
        if (user != null) {
            System.out.println("User " + username + " is offering a ride on route: " + route + " with " + seats + " seats.");
        } else {
            System.out.println("User not found for username: " + username);
        }
        return;
    }


    }

=======
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RideSharingFacade {

    private UserDAO userDAO ;
    private  RideDAO rideDAO;

    public RideSharingFacade(Connection connection) throws SQLException {
        this.userDAO = new UserDAO(connection);
        this.rideDAO = new RideDAO(connection);
    }

    public void registerUser(String username, String email , String phone) throws SQLException {
        userDAO.addUser(username, email, phone);
    }

    public void postRide(String rideId, String driverId, String origin, String destination, String departureTime, int seatsAvailable) throws SQLException {
        rideDAO.addRide(rideId, driverId, origin, destination, departureTime, seatsAvailable);
    }

    public void listAllUsers(){
        try (ResultSet resultSet = userDAO.getAllUsers()){
            while (resultSet.next()) {
                System.out.println("Username: " + resultSet.getString("username" + ", Email:" + resultSet.getString("email" + "Phone Number" + resultSet.getString("phone"))));
            }
        }catch (Exception exception){
            exception.getMessage();
        }
    }
}
>>>>>>> Stashed changes
