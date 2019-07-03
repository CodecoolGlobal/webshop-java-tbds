package com.codecool.shop.model;

public class Cart {

    public String name;
    public int price;
    public int quanity;


    Cart(){}

    public Cart(int price, String name){
        this.price = price;
        this.name = name;
        this.quanity = 1;
    }
}
