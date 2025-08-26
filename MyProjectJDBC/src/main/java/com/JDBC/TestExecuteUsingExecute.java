package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestExecuteUsingExecute {
    private static String url = "jdbc:postgresql://localhost:5432/college?user=postgres&password=hritick123";

    public static void main(String[] args) {
        try (Connection c = DriverManager.getConnection(url);
             Statement s = c.createStatement()) {

            String query = "SELECT * FROM students";

            // Use execute() instead of executeQuery()
            boolean hasResultSet = s.execute(query);

            if (hasResultSet) {
                ResultSet rs = s.getResultSet(); // get the result set

                while (rs.next()) {
                    System.out.println("Student ID: " + rs.getInt(2));
                    System.out.println("Student Name: " + rs.getString(1));
                    System.out.println("Student Email: " + rs.getString(3));
                    System.out.println("-----------------------------");
                }

                rs.close(); // Close ResultSet
            } else {
                System.out.println("No result returned by the query.");
            }

        } catch (SQLException e) {
            System.out.println("Database error occurred!");
            e.printStackTrace();
        }
    }
}
