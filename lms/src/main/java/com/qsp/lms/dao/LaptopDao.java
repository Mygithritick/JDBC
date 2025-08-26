package com.qsp.lms.dao;

import java.sql.*;
import java.util.Scanner;

import com.qsp.lms.model.Laptop;

public class LaptopDao {
    private static final String URL = "jdbc:postgresql://localhost:5432/shop?user=postgres&password=hritick123";
    private static final Scanner sc = new Scanner(System.in);
    private static Connection c;

    // Static block to initialize the connection
    static {
        try {
            c = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.err.println("Database connection failed.");
            e.printStackTrace();
        }
    }

    // Save laptop to database
    public static void saveLaptop(Laptop l) {
        String query = "INSERT INTO laptop VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, l.getId());
            ps.setString(2, l.getBrand());
            ps.setDouble(3, l.getPrice());
            ps.setString(4, l.getModel());
            ps.executeUpdate();
            System.out.println("Laptop saved successfully.");
        } catch (SQLException e) {
            System.err.println("Failed to save laptop.");
            e.printStackTrace();
        }
    }

    // Get laptop by ID
    public static Laptop getLaptopById(int id) throws SQLException {
        String query = "SELECT * FROM laptop WHERE id = ?";

        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Laptop l = new Laptop();
                l.setId(rs.getInt("id"));
                l.setBrand(rs.getString("brand"));
                l.setPrice(rs.getDouble("price"));
                l.setModel(rs.getString("model"));
                return l;
            }
        }
        return null;
    }

    // Delete laptop by ID
    public static boolean deleteById(int id) throws SQLException {
        if (getLaptopById(id) == null) {
            System.out.println("Laptop not found with ID: " + id);
            return false;
        }

        String query = "DELETE FROM laptop WHERE id = ?";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Laptop deleted successfully.");
            return true;
        }
    }

    // Find and print all laptops
    public static void findAll() throws SQLException {
        String query = "SELECT * FROM laptop";

        try (Statement s = c.createStatement();
             ResultSet rs = s.executeQuery(query)) {

            while (rs.next()) {
                Laptop l = new Laptop();
                l.setId(rs.getInt("id"));
                l.setBrand(rs.getString("brand"));
                l.setPrice(rs.getDouble("price"));
                l.setModel(rs.getString("model"));
                System.out.println(l);
            }
        }
    }

    // Update laptop price by ID
    public static void updateLaptopPrice(int id) throws SQLException {
        Laptop laptop = getLaptopById(id);
        if (laptop == null) {
            System.out.println("Please enter a valid ID. Laptop not found.");
            return;
        }

        System.out.print("Enter new price: ");
        double newPrice = sc.nextDouble();
        
        

        String query = "UPDATE laptop SET price = ? WHERE id = ?";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setDouble(1, newPrice);
            ps.setInt(2, id);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Price updated successfully.");
            } else {
                System.out.println("Price update failed.");
            }
        }
    }
    //close the connection
    public static void closeConnection()
    {
    	try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
