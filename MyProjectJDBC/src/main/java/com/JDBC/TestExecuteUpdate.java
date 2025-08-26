package com.JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class TestExecuteUpdate {
	private static String url = "jdbc:postgresql://localhost:5432/college?user=postgres&password=hritick123";
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String args[]) {
		try(Connection c = DriverManager.getConnection(url);) {

			String query = "UPDATE students SET name = ? WHERE id = ?";
			PreparedStatement ps = c.prepareStatement(query);

			System.out.println("User, enter ID to update name:");
			int id = scanner.nextInt();
			scanner.nextLine(); // consume newline

			System.out.println("User, enter new name:");
			String name = scanner.nextLine();

			// Set parameters in correct order
			ps.setString(1, name); // 1st '?'
			ps.setInt(2, id);      // 2nd '?'

			int noOfRowsAffected = ps.executeUpdate();
			System.out.println("This many rows were affected by the query: " + noOfRowsAffected);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
