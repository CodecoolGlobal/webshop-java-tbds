package com.codecool.shop;

import com.codecool.shop.model.User;

import java.util.ArrayList;
import java.util.List;

public class Global {
    private Global global = null;
    private User user;
    private Global(){}
    private List<Order>orders = new ArrayList<>();

    public User getUserById(){
        return this.user;
    }
    public Global getInstance(){
        if(global== null){
            this.global = new Global();
            this.user = new User();
        }
        return global;

    }

    public Order getActualOrder(){
        if(orders.isEmpty()){
            return createNewOrder();
        }
        return orders.get(orders.size()-1);
    }
    public Order createNewOrder(){
        Order order = new Order();
        orders.add(order);
        return order;
    }
}
