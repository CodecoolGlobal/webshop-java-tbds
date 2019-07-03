package com.codecool.shop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final int id;
    private static int counter = 0;
    private String date; // todo fix datatype of Date
    private Cart cart;
    private BigDecimal totalPrice;
    private boolean payed;

    Order(){
        this.id = counter++;
        this.date = "Today"; // todo: fix date in Constructor
        this.cart = new Cart();
        this.totalPrice = new BigDecimal(0);
        this.payed = false;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public Cart getCart() {
        return cart;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public boolean isPayed() {
        return payed;
    }
}
