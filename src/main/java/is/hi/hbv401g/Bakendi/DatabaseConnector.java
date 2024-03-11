package is.hi.hbv401g.Bakendi;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String url = "jdbc:sqlite:src/main/resources/flightBooking.db";
    public static Connection connect(){
        Connection connection = null;
        try {
            connection = java.sql.DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established."+connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void main(String[] args){
        connect();
    }
}
