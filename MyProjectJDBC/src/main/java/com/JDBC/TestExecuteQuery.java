package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestExecuteQuery {
    private static final String URL = "jdbc:postgresql://localhost:5432/college";
    private static final String USER = "postgres";
    private static final String PASSWORD = "hritick123";

    public static void main(String[] args) {
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            // Step 1 & 2: Load driver (optional in modern JDBC) and get connection
            c = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Create statement
            s = c.createStatement();

            // Step 4: Execute query
            String query = "SELECT * FROM students";
            rs = s.executeQuery(query);

            // Step 5: Process result set
            while (rs.next()) {
                System.out.println("Student ID: " + rs.getInt("id"));
                System.out.println("Student Name: " + rs.getString("name"));
                System.out.println("Student Email: " + rs.getString("email"));
                System.out.println("--------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close resources in reverse order
            try {
                if (rs != null) rs.close();
                if (s != null) s.close();
                if (c != null) c.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
