package medinovahealthcare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBase {
    private Connection connection;
    
    // Method to establish connection
    public Connection getConnection() {
        try {
            // Update with your database name, username, and password
        String url = "jdbc:mysql://localhost:3306/database_car";
        String user = "xheis";
        String password = "(Xhes3iiI*)";

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Method to close connection
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


