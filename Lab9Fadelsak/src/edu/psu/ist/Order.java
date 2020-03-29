package edu.psu.ist;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import javax.swing.*;
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

enum orderType {Pickup, Delivery, DineIn, undefined}

public class Order {
    //Class Level Variables - Protect the data
    private int orderId;
    private orderType oType;
    private Customer Customer;
    private ArrayList<MenuItem> menuItems;

    //Constructor Method
    public Order(int _orderId, orderType _oType, Customer _cCust){
        this.orderId = _orderId;
        this.oType = _oType;
        this.Customer = _cCust;
        this.menuItems = new ArrayList<MenuItem>();
    }

    //Setters and Getters
    public int getorderId() { return orderId; }
    public void setorderId(int _orderId) {this.orderId = _orderId;}

    public orderType getOrderType() { return oType; }
    public void setOrderType(orderType _oType) {this.oType = _oType;}

    public Customer getCustomer() { return Customer; }
    public void setCustomer(Customer _cCust) {this.Customer = _cCust;}

    public ArrayList<MenuItem> getMenuItems() { return menuItems;}
    public void addMenuItem(MenuItem menuItem) {this.menuItems.add(menuItem);}

    public double getSubTotal(){
        double sum = 0;
        for(MenuItem item : menuItems){
            sum += item.getPrice();
        }
        return sum;
    }

    public void printOrder(){
        for (MenuItem item : this.menuItems){
            System.out.println(item);
        }
    }

    public String printCompiled(){

        String itemsString = "\n";

        for (MenuItem item : this.menuItems)
        {
            itemsString += item.toString() + "\n";
        }
        return itemsString;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", oType=" + oType +
                ", customer=" + this.getCustomer().toString() +
                ", menuItems=" + this.printCompiled() +
                '}';
    }
}
