package com.jdbc1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test{
	static String url="jdbc:postgresql://localhost:5432/college";
	static String username="postgres";
	static String password="hritick123";
	public static void main(String args[])
	{
		Connection c=null;
		PreparedStatement ps=null;
		Scanner sc=new Scanner(System.in);
		try {
			c=DriverManager.getConnection(url,username,password);
			String query="insert into students (name,id,email)values(?,?,?)";
			ps=c.prepareStatement(query);
			 System.out.print("Enter ID: ");
			 ps.setInt(2,sc.nextInt());
	            sc.nextLine();  // Consume newline left-over
	            System.out.print("Enter Name: ");
	            ps.setString(1, sc.nextLine());
	            System.out.print("Enter Email: ");
	            ps.setString(3, sc.nextLine());
			int rows=ps.executeUpdate();
			System.out.println(rows+"row inserted");
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
}