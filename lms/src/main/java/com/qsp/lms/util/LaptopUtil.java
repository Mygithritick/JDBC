package com.qsp.lms.util;

import java.util.Scanner;
import com.qsp.lms.model.Laptop;

public class LaptopUtil {
    private static Scanner s = new Scanner(System.in);

    public static Laptop createLaptop() {
        Laptop l = new Laptop();

        System.out.println("User enter laptop id");
        l.setId(s.nextInt());
        s.nextLine(); // consume leftover newline

        System.out.println("User enter laptop brand");
        l.setBrand(s.nextLine());

        System.out.println("User enter laptop model");
        l.setModel(s.nextLine());

        System.out.println("User enter laptop price");
        l.setPrice(s.nextDouble());

        return l;
    }
}
