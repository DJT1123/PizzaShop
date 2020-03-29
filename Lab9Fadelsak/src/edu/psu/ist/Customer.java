package edu.psu.ist;
import java.util.ArrayList;

/*
Project: Lab 9 Pizza Shop
Purpose Details: Pizza ordering application
Course: IST 242
Author: Tom Fadelsak
Date Developed: 3/14/19
Last Date Changed: 3/28/19
Rev: 9
 */

public class Customer {
    //Class Level Variables - Protect the data
    private int customerId;
    private String customerName;
    private String customerPhoneNumber;
    private String customerAddress;

    //Constructor Method
    public Customer(int _customerId, String _customerName, String _customerPhoneNumber, String _customerAddress) {
        this.customerId = _customerId;  //Increments the ID count
        this.customerName = _customerName;
        this.customerPhoneNumber = _customerPhoneNumber;
        this.customerAddress = _customerAddress;
    }

        //Setters and Getters
    public int getCustomerId() { return customerId; }
    public void setCustomerId(int _customerId) {this.customerId = _customerId;}

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String _customerName) {this.customerName = _customerName;}

    public String getCustomerAddress() { return customerAddress; }
    public void setCustomerAddress(String _customerAddress) {this.customerAddress = _customerAddress;}

    public String getCustomerPhoneNumber() { return customerPhoneNumber; }
    public void setCustomerPhoneNumber(String _customerPhoneNumber) {this.customerPhoneNumber = _customerPhoneNumber;}

    public static void printCustomer(ArrayList<Customer> cList){
        for (Customer cust: cList){
            System.out.println("Customer Id: " + cust.getCustomerId());
            System.out.println("Customer Name: " + cust.getCustomerName());
            System.out.println("Customer Phone: " + cust.getCustomerPhoneNumber());
            System.out.println("Customer Address: " + cust.getCustomerAddress());
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerPhoneNumber='" + customerPhoneNumber + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                '}';
    }
}
