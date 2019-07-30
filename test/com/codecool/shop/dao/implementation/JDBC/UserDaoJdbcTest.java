package com.codecool.shop.dao.implementation.JDBC;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoJdbcTest {



    @org.junit.jupiter.api.Test
    void getUser() {

    }

    @org.junit.jupiter.api.Test
    void updateUser() {
        assertDoesNotThrow(()->{
            String query = "UPDATE  \"user\"" +
                    "SET name = 'Pista'" +
                    "WHERE id = '" + 2 + "';";
            executeQuery();

        });
    }
}