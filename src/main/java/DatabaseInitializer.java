import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {
    public static void initialize(){
        try(Connection connection = DatabaseConnection.getConnecection();
            Statement statement =connection.createStatement()) {

            //Schema creation
               //users
            String createUsersTable =
               "CREATE TABLE IF NOT EXISTS Users (\n" +
               " username PRIMARY KEY  NOT NULL, \n" +
               " email TEXT UNIQUE NOT NULL,\n" +
               " phone number TEXT,\n" + ");";
                //Ride table
            String createRidesTable =
                    "CREATE TABLE IF NOT EXISTS Rides (\n" +
                            "    ride_id TEXT PRIMARY KEY,\n" +
                            "    driver_username TEXT NOT NULL,\n" +
                            "    origin TEXT NOT NULL,\n" +
                            "    destination TEXT NOT NULL,\n" +
                            "    departure_time TEXT NOT NULL,\n" +
                            "    seats_available INTEGER NOT NULL,\n" +
                            "    status TEXT CHECK(status IN ('AVAILABLE', 'FULL', 'COMPLETED')) DEFAULT 'AVAILABLE'," +
                            "    FOREIGN KEY(driver_id) REFERENCES Users(id)" +
                            ");";

                       // riderequest
            String createRideRequestsTable =
                    "CREATE TABLE IF NOT EXISTS RideRequests (\n" +
                            "    request_id TEXT PRIMARY KEY,\n" +
                            "    rider_username TEXT NOT NULL,\n" +
                            "    origin TEXT NOT NULL,\n" +
                            "    destination TEXT NOT NULL,\n" +
                            "    preferred_time TEXT,\n" +
                            "    status TEXT CHECK(status IN ('PENDING', 'ACCEPTED', 'REJECTED')) DEFAULT 'PENDING',\n" +
                            "    FOREIGN KEY(rider_id) REFERENCES Users(id)\n" +
                            ");";
             //  id
            statement.executeUpdate(createUsersTable);
            statement.executeUpdate(createRidesTable);
            statement.executeUpdate(createRideRequestsTable);
            System.out.println("Tables created successfully!");
        } catch (Exception e) {
            e.getMessage();

    }
    }
}
