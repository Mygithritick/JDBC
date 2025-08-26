package com.qsp.lms;

import java.sql.SQLException;
import java.util.Scanner;

import com.qsp.lms.dao.LaptopDao;
import com.qsp.lms.model.Laptop;
import com.qsp.lms.util.LaptopUtil;

public class LaptopDriver {
    public static void main(String[] args) throws SQLException {
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Laptop Menu ---");
            System.out.println("1: Save Laptop");
            System.out.println("2: Find Laptop by ID");
            System.out.println("3: Delete Laptop by ID");
            System.out.println("4: Find All Laptops");
            System.out.println("5.Update by ID");
            System.out.println("6: Exit");
            System.out.print("Enter your choice: ");
            int choice = s.nextInt();

            switch (choice) {
                case 1:
                    LaptopDao.saveLaptop(LaptopUtil.createLaptop());
                    System.out.println("Successfully inserted laptop record");
                    break;

                case 2:
                    System.out.print("Enter laptop ID to find: ");
                    int findId = s.nextInt();
                    Laptop foundLaptop = LaptopDao.getLaptopById(findId);
                    if (foundLaptop != null) {
                        System.out.println("Laptop Found: " + foundLaptop);
                    } else {
                        System.out.println("Laptop not found.");
                    }
                    break;

                case 3:
                	LaptopDao.findAll();
                    System.out.print("Enter laptop ID to delete: ");
                    int deleteId = s.nextInt();
                    if (LaptopDao.deleteById(deleteId)) {
                        System.out.println("Laptop deleted successfully.");
                    } else {
                        System.out.println("Laptop not found.");
                    }
                    break;

                case 4:
                    LaptopDao.findAll();
                    break;
                case 5:
                	LaptopDao.findAll();
                	System.out.println("User enter laptop id to update");
                	LaptopDao.updateLaptopPrice(s.nextInt());
                	break;
                case 6:
                    System.out.println("Exiting... Thank you!");
                    LaptopDao.closeConnection();
                    return;

                default:
                    System.out.println("Please enter a valid input.");
                    break;
            }
        }
    }
}
