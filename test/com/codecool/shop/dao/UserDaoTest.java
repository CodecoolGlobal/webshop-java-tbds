package com.codecool.shop.dao;

import com.codecool.shop.dao.implementation.JDBC.UserDaoJdbc;
import com.codecool.shop.model.User;

import static org.junit.jupiter.api.Assertions.*;

public class UserDaoTest {

    UserDao testObject = new UserDaoJdbc();


    @org.junit.jupiter.api.Test
    void getUser() {
        User carl = new User("carl", "carl@carl.com");
        testObject.add(carl);

        assertDoesNotThrow(()-> {
            testObject.getUser("carl@carl");
        });
    }

    @org.junit.jupiter.api.Test
    void updateUser() {
        User john = new User("john", "john@john.com");
        testObject.add(john);
        john.setName("johndoe");

        assertDoesNotThrow(()->{
            testObject.updateUser(john);
        });
    }
}