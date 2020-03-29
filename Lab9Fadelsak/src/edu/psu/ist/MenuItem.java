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

import java.util.ArrayList;

public class MenuItem {

    //Class Level Variables - Protect the data
    private int id;
    private String category;
    private String name;
    private double price;

    //Constructor Method
    public MenuItem(int id, String category, String name, double price){
        this.id = id;
        this.category = category;
        this.name = name;
        this.price = price;
    }

    //Setters and Getters
    public int getId() { return id; }
    public void setId(int id) {this.id = id;}

    public String getCategory() { return category; }
    public void setCategory(String category) {this.category = category;}

    public double getPrice() { return price; }
    public void setPrice(double _menuPrice) {this.price = price;}

    public String getName() { return name; }
    public void setName(String name) {this.name = name;}

    @Override
    public String toString() {
        return "MenuItem{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
