package com.JDBC;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

public class TestRegisterDriver {
	public static void main(String args[])
	{
		//Create driver object
		Driver driver=new Driver();
		try {
			//register this driver object in your jdbc api 
			//by using driver manager class
			DriverManager.registerDriver(driver);
			System.out.println("Successfully registered the driver");
		}
		catch(SQLException e)
		{
			//TODO Auto generated catch block
			e.printStackTrace();
		}
	}

}
