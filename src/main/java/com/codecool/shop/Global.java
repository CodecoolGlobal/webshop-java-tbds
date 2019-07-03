package com.codecool.shop;

import com.codecool.shop.model.User;

public class Global {
    private Global global = null;
    private User user;
    private Global(){}

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
}
