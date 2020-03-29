package edu.psu.ist;
/*
Project: Lab 9 Pizza Shop
Purpose Details: Pizza ordering application
Course: IST 242
Author: Tom Fadelsak
Date Developed: 3/14/19
Last Date Changed: 3/28/19
Rev: 9
 */

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int cCount = 4; //TODO UPDATE THIS IF YOU ARE HARDCODING ANY CUSTOMERS!!!
        int oCount = 0;
        int tCount = 0;

        final char EXIT_CODE = 'E';
        final char CUST_CODE = 'C';
        final char MENU_CODE = 'M';
        final char ORDE_CODE = 'O';
        final char TRAN_CODE = 'T';
        final char CUST_PRNT = 'P';
        final char PRNT_ORDR = 'R';
        final char HELP_CODE = '?';
        char userAction;
        final String PROMPT_ACTION = "######### MAIN MENU ##########\nEnter a C to enter a New Customer,\nEnter a P to Print all Customers,\nEnter a M to List Food Menu,\nEnter a O to Add a New Order,\nEnter a T to List all Transactions \nEnter a R to Print all Orders\nEnter a E to Exit: ";
        ArrayList<Customer> cList = new ArrayList<>();
        ArrayList<MenuItem> mList = new ArrayList<>();
        ArrayList<Order> oList = new ArrayList<>();
        ArrayList<Transaction> tList = new ArrayList<>();

        //SETTING HARD DATA
        MenuItem menuItem1 = new MenuItem(1, "Pizza Type", "Plain", 8.99);
        MenuItem menuItem2 = new MenuItem(2, "Pizza Type", "Meat", 10.99);
        MenuItem menuItem3 = new MenuItem(3, "Pizza Type", "Extra", 12.99);
        MenuItem menuItem4 = new MenuItem(4, "Pizza Type", "Veg", 9.99);
        MenuItem menuItem5 = new MenuItem(5, "App", "Fries", 4.99);
        MenuItem menuItem6 = new MenuItem(6, "App", "Garlic Knots", 2.99);
        MenuItem menuItem7 = new MenuItem(7, "App", "Onion Rings", 4.99);
        MenuItem menuItem8 = new MenuItem(8, "Drink", "Coke", 2.99);
        MenuItem menuItem9 = new MenuItem(9, "Drink", "Sprite", 2.99);
        MenuItem menuItem10 = new MenuItem(10, "Drink", "IceTea", 1.99);

        mList.add(menuItem1);
        mList.add(menuItem2);
        mList.add(menuItem3);
        mList.add(menuItem4);
        mList.add(menuItem5);
        mList.add(menuItem6);
        mList.add(menuItem7);
        mList.add(menuItem8);
        mList.add(menuItem9);
        mList.add(menuItem10);

        Customer cust1 = new Customer(1, "Tom", "267", "229 Rena St");
        Customer cust2 = new Customer(2, "Mike", "215", "272 Shelmire St");
        Customer cust3 = new Customer(3, "John", "878", "645 Woodhaven Rd");

        cList.add(cust1);
        cList.add(cust2);
        cList.add(cust3);

        userAction = getAction(PROMPT_ACTION);

        while (userAction != EXIT_CODE) {
            switch (userAction) {
                case CUST_CODE: //TODO create a new customer
                    Customer cust = new Customer(cCount++, null, null, null);
                    Scanner scnr = new Scanner(System.in);
                    System.out.println("Please Enter your Name: ");
                    cust.setCustomerName(scnr.nextLine());
                    System.out.println("Please Enter your Phone: ");
                    cust.setCustomerPhoneNumber(scnr.nextLine());
                    System.out.println("Please Enter your Address: ");
                    cust.setCustomerAddress(scnr.nextLine());
                    cList.add(cust);
                    break;
                //#############################################################################################################################################
                case CUST_PRNT: //TODO print all customers
                    Customer.printCustomer(cList);
                    break;
                //#############################################################################################################################################
                case MENU_CODE: //TODO print viewing menu
                    System.out.println("Pick Menu Category\nType 1 for Pizza\nType 2 for App\nType 3 for Drink");
                    int option = prompt.callmenu(3);
                    while (option != 0) {
                        switch (option) {
                            case 1:
                                for (MenuItem item : mList) {
                                    if (item.getCategory() == "Pizza Type") {
                                        System.out.println(item.getName() + " " + item.getPrice());
                                    }
                                }
                                break;
                            case 2:
                                for (MenuItem item : mList) {
                                    if (item.getCategory() == "App") {
                                        System.out.println(item.getName() + " " + item.getPrice());
                                    }
                                }
                                break;
                            case 3:
                                for (MenuItem item : mList) {
                                    if (item.getCategory() == "Drink") {
                                        System.out.println(item.getName() + " " + item.getPrice());
                                    }
                                }
                                break;
                        }
                        System.out.println("\nPick Menu Category\nType 1 for Pizza\nType 2 for App\nType 3 for Drink");
                        option = prompt.callmenu(3);
                    }
                    break;
                //#############################################################################################################################################
                case ORDE_CODE: //TODO Creates a new Order
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter the phone number of customer for the new order");
                    String testphone = sc.next();
                    boolean isfound = false;

                    for (Customer customer : cList) {
                        if (customer.getCustomerPhoneNumber().equals(testphone)) {
                            isfound = true;
                            System.out.println("\nCustomer Found: " + customer.getCustomerName());
                            Order order = new Order(oCount++, null, null);
                            order.setCustomer(customer);
                            System.out.println("What is the order type?\nPress 1 for Pickup\nPress 2 for Delivery\nPress 3 for DineIn");
                            option = prompt.hardmenuforenum(3);

                            while (option != 0) {
                                switch (option) {
                                    case 1:
                                        order.setOrderType(orderType.Pickup);
                                        System.out.println("Order Type set to Pickup");
                                        option = 0;
                                        break;
                                    case 2:
                                        order.setOrderType(orderType.Delivery);
                                        System.out.println("Order Type set to Delivery");
                                        option = 0;
                                        break;
                                    case 3:
                                        order.setOrderType(orderType.DineIn);
                                        System.out.println("Order Type set to DineIn");
                                        option = 0;
                                        break;
                                    case 4:
                                        order.setOrderType(orderType.undefined);
                                        System.out.println("Order Type set to undefined");
                                        option = 0;
                                        break;
                                }
                            }

                            System.out.println("\nNow Add Item to the order!");
                            System.out.println("Pick Menu Category\nType 1 for Pizza\nType 2 for App\nType 3 for Drink");
                            option = prompt.callmenuFinish(3);
                            int count = 0;
                            int menuOption;
                            while (option != 0) {
                                switch (option) {
                                    case 1:
                                        ArrayList<MenuItem> pizzaTypes = new ArrayList<MenuItem>();
                                        for (MenuItem item : mList) {
                                            if (item.getCategory() == "Pizza Type") {
                                                count = count + 1;
                                                System.out.println(count + " " + item.getName() + " " + item.getPrice());
                                                pizzaTypes.add(item);
                                            }
                                        }
                                        System.out.println("Enter the number to add item to the order.");
                                        menuOption = prompt.callmenu(count);
                                        order.addMenuItem(pizzaTypes.get(menuOption -1));
                                        count = 0;
                                        break;

                                    case 2:
                                        ArrayList<MenuItem> apps = new ArrayList<MenuItem>();
                                        for (MenuItem item : mList) {
                                            if (item.getCategory() == "App") {
                                                count = count + 1;
                                                System.out.println(count + " " + item.getName() + " " + item.getPrice());
                                                apps.add(item);
                                            }
                                        }
                                        System.out.println("Enter the number to add item to the order.");
                                        menuOption = prompt.callmenu(count);
                                        order.addMenuItem(apps.get(menuOption -1));
                                        count = 0;
                                        break;

                                    case 3:
                                        ArrayList<MenuItem> drink = new ArrayList<MenuItem>();
                                        for (MenuItem item : mList) {
                                            if (item.getCategory() == "Drink") {
                                                count = count + 1;
                                                System.out.println(count + " " + item.getName() + " " + item.getPrice());
                                                drink.add(item);
                                            }
                                        }
                                        System.out.println("Enter the number to add item to the order.");
                                        menuOption = prompt.callmenu(count);
                                        order.addMenuItem(drink.get(menuOption -1));
                                        count = 0;
                                        break;
                                }
                                System.out.println("\nPick Menu Category\nType 1 for Pizza\nType 2 for App\nType 3 for Drink");
                                option = prompt.callmenuFinish(3);
                            }
                            oList.add(order);

                            Transaction trans = new Transaction(tCount++, order, null);
                            System.out.println("Pick Payment type:\n1: Cash \n2: Credit");
                            option = prompt.hardmenuforenum1(2);
                            if(option == 1){
                                trans.setPaymentType(PaymentType.cash);
                            }
                            if(option == 2){
                                trans.setPaymentType(PaymentType.credit);
                            }
                            tList.add(trans);
                        }
                    }
                    if (!isfound) {
                        System.out.println("Customer Not Found - Add to customer database");
                    }
                    break;
                //#############################################################################################################################################
                case PRNT_ORDR: //TODO Prints all Orders
                    for(Order order : oList) {
                        System.out.println(order);
                    }
                    break;
                //#############################################################################################################################################
                case TRAN_CODE: //TODO Prints all Transactions
                    Transaction.listTransactions(tList);
                    break;
            }
            userAction = getAction(PROMPT_ACTION);
        }
    }

    public static char getAction(String prompt) {
        Scanner scnr = new Scanner(System.in);
        String answer = "";
        System.out.println(prompt);
        answer = scnr.nextLine().toUpperCase() + " ";
        char firstChar = answer.charAt(0);
        return firstChar;
    }
}