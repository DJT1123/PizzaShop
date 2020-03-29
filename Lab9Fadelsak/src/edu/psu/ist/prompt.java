package edu.psu.ist;
import java.util.Scanner;

/*
Project: Lab 9 Pizza Shop
Purpose Details: Pizza ordering application
Course: IST 242
Author: Tom Fadelsak
Date Developed: 3/14/19
Last Date Changed: 3/28/19
Rev: 9
 */

public class prompt {
    public static Integer callmenu(int a) {
        try {

            System.out.println("Enter a number between 1 and " + a + " or 0 to go back!");
            Scanner sc = new Scanner(System.in);
            Integer userInputA = sc.nextInt();

            while ((userInputA > a) || (userInputA < 0)) {
                System.out.println("Invalid input");
                userInputA = sc.nextInt();
            }

            return userInputA;
        } catch (Exception e) {
            return 0;
        }
    }
    public static Integer callmenuFinish(int a) {
        try {

            System.out.println("Enter a number between 1 and " + a + " or 0 to Finish and checkout order");
            Scanner sc = new Scanner(System.in);
            Integer userInputA = sc.nextInt();

            while ((userInputA > a) || (userInputA < 0)) {
                System.out.println("Invalid input");
                userInputA = sc.nextInt();
            }

            return userInputA;
        } catch (Exception e) {
            return 0;
        }
    }
    public static Integer hardmenuforenum(int a) {
        try {

            System.out.println("Enter a number between 1 and " + a);
            Scanner sc = new Scanner(System.in);
            Integer userInputA = sc.nextInt();

            while ((userInputA > a) || (userInputA < 0)) {
                System.out.println("Invalid input");
                userInputA = sc.nextInt();
            }

            return userInputA;
        } catch (Exception e) {
            return 4;
        }
    }
    public static Integer hardmenuforenum1(int a) {
        try {

            System.out.println("Enter a number between 1 and " + a);
            Scanner sc = new Scanner(System.in);
            Integer userInputA = sc.nextInt();

            while ((userInputA > a) || (userInputA < 0)) {
                System.out.println("Invalid input");
                userInputA = sc.nextInt();
            }

            return userInputA;
        } catch (Exception e) {
            return 1;
        }
    }
}


