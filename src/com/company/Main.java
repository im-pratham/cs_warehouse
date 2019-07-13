package com.company;

import com.company.Warehouse.Gadget;
import com.company.Warehouse.Warehouse;
import com.company.Warehouse.Widget;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);

        int choice = 0;
//        Gadget g = new Gadget("ABC", 0.3, 4);
//        Product gb = new Widget("ABC", 0.3, new Date());
//        System.out.println(g.equals(gb));
        int limit = 10;
        Warehouse warehouse = new Warehouse(limit);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d-M-yyyy");

        do {
            System.out.println("1. Enter Gadget\n" +
                    "2. Enter Widget\n" +
                    "3. Delete Gadget\n" +
                    "4. Delete Widget\n" +
                    "5. Print\n" +
                    "6. Exit\n" +
                    "7. Get Total Value\n" +
                    "8. Get Total Space\n");
            choice = sc.nextInt();
            try {
                switch (choice) {
                    case 1:
                        System.out.println("Enter Title, Price, #packs: ");
                        System.out.println(warehouse.add(new Gadget(sc.next(), sc.nextDouble(), sc.nextInt())));
                        break;
                    case 2:
                        System.out.println("Enter Title, Price, Expiry Date: ");
                        System.out.println(warehouse.add(new Widget(sc.next(), sc.nextDouble(), LocalDate.parse(sc.next(), dateFormat))));
                        break;
                    case 3:
                        System.out.println("Enter Title, Price, #packs: ");
                        System.out.println(warehouse.remove(new Gadget(sc.next(), sc.nextDouble(), sc.nextInt())));
                        break;
                    case 4:
                        System.out.println("Enter Title, Price, Expiry Date: ");
                        System.out.println(warehouse.remove(new Widget(sc.next(), sc.nextDouble(), LocalDate.parse(sc.next(), dateFormat))));
                        break;
                    case 5:
                        System.out.println(warehouse);
                        break;
                    case 7:
                        System.out.println(warehouse.getTotalValue());
                        break;
                    case 8:
                        System.out.println(warehouse.getTotalSpace());
                        break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (choice != 6);
    }
}
