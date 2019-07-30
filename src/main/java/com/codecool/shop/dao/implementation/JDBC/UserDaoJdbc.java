package com.codecool.shop.dao.implementation.JDBC;

import com.codecool.shop.dao.UserDao;
import com.codecool.shop.model.User;

import java.sql.*;

public class UserDaoJdbc implements UserDao {
    private static final String DATABASE = "jdbc:postgresql://localhost:5432/webshop";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "123";

    @Override
    public User getUser(int id) {
        String query = "SELECT * FROM users" +
                "WHERE id =" + id + ";"  ;
        return null;
    }

    @Override
    public void updateUser(User user) {
        String query = "UPDATE  \"user\"" +
                "SET name = 'Kalman'" +
                "WHERE id = '" + 1 + "';";
        executeQuery(query);
    }
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                DATABASE,
                DB_USER,
                DB_PASSWORD);
    }

    private void executeQuery(String query) {
        try (Connection connection = getConnection();
             Statement statement =connection.createStatement();
        ){
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
