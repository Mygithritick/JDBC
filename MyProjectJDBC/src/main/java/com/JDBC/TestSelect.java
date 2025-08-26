package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestSelect {
    // URL with embedded username and password
    static String url = "jdbc:postgresql://localhost:5432/college?user=postgres&password=hritick123";

    public static void main(String[] args) {
        try {
            // Step 1: Load the PostgreSQL driver
            Class.forName("org.postgresql.Driver");

            // Step 2: Create connection
            Connection c = DriverManager.getConnection(url);

            // Step 3: Create PreparedStatement
            String query = "SELECT * FROM students";
            PreparedStatement ps = c.prepareStatement(query);

            // Step 4: Execute query
            ResultSet rs = ps.executeQuery();

            // Step 5: Process result
            while (rs.next()) {
                // Assuming table has columns: id, name, age
                String name = rs.getString("name");
                int id = rs.getInt("id");
                 String email= rs.getString("email");
                System.out.println("ID: " + id + ", Name: " + name + ", Email " + email);
            }

            // Closing resources (optional but recommended)
            rs.close();
            ps.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
