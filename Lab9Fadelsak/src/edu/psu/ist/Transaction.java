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

enum PaymentType {cash, credit}

public class Transaction {

    //Class Level Variables - Protect the data
    private int transactionId;
    private Order order;
    private PaymentType pType;

    //Constructor Method
    public Transaction(int _transactionId, Order _order, PaymentType _pType){
        this.transactionId = _transactionId;
        this.order = _order;
        this.pType = _pType;
    }

    //Setters and Getters
    public int getTransactionId() { return transactionId; }
    public void setTransactionId(int _transactionId) {this.transactionId = _transactionId;}

    public Order getOrder() { return order; }
    public void setOrder(Order _order) {this.order = _order;}

    public PaymentType getPaymentType() { return pType; }
    public void setPaymentType(PaymentType _pType) {this.pType = _pType;}

    public static void listTransactions(ArrayList<Transaction> tList){
        for (Transaction trans: tList){
            Order currentOrder = trans.getOrder();
            System.out.println("Transaction ID: " + trans.getTransactionId());
            System.out.println("Customers Name: " + currentOrder.getCustomer());
            System.out.println("Order Subtotal:" + currentOrder.getSubTotal());
            System.out.println("Payment Type: " + trans.getPaymentType());
        }
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", order=" + order +
                ", Sum= " + order.getSubTotal() +
                ", pType=" + pType +
                '}';
    }
}
