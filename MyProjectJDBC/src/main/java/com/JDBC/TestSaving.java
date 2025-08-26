package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSaving {
    static String url = "jdbc:postgresql://localhost:5432/college";  // changed from postgres to college
    static String username = "postgres";
    static String password = "hritick123";

    public static void main(String[] args) {
        Connection c = null;
        try {
            // Step 1: load the driver
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver loaded successfully");

            // Step 2: get connection
            c = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database successfully");

            // Step 3: prepare query and statement
            String query = "INSERT INTO students VALUES('Akash', 3, 'modakhritick@gmail.com')";
            Statement statement = c.createStatement();

            // Step 4: execute
            int rowsAffected = statement.executeUpdate(query);
            System.out.println(rowsAffected + " row(s) inserted");

            // Step 5: close statement
            statement.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error occurred during connection or query execution");
            e.printStackTrace();
        } finally {
            try {
                if (c != null) {
                    c.close();
                    System.out.println("Connection closed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
