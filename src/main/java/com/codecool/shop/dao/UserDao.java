package com.codecool.shop.dao;

import com.codecool.shop.model.User;

public interface UserDao {
    void getUser(String emailAddress);

    void updateUser(User user);

    void add(User john);
}
