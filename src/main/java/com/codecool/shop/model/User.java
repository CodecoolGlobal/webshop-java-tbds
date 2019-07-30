package com.codecool.shop.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getPaypalUsername() {
        return paypalUsername;
    }

    public void setPaypalUsername(String paypalUsername) {
        this.paypalUsername = paypalUsername;
    }

    public String getPaypalPassword() {
        return paypalPassword;
    }

    public void setPaypalPassword(String paypalPassword) {
        this.paypalPassword = paypalPassword;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getExpirityDate() {
        return expirityDate;
    }

    public void setExpirityDate(String expirityDate) {
        this.expirityDate = expirityDate;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    private String name;
    private String emailAddress;
    private String phoneNumber;
    private String billingAddress;
    private String shippingAddress;
    private String paypalUsername;
    private String paypalPassword;
    private String cardNumber;
    private String cardHolder;
    private String expirityDate;
    private String cardCode;
    private List<Product> cart = new ArrayList<>();


    public User(String name, String emailAddress) {
        this.name = name;
        this.emailAddress = emailAddress;
    }
}
