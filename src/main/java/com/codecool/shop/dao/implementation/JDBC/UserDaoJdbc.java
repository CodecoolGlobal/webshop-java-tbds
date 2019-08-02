package com.codecool.shop.dao.implementation.JDBC;

import com.codecool.shop.dao.UserDao;
import com.codecool.shop.model.User;

import java.sql.*;

public class UserDaoJdbc implements UserDao {
    private static final String DATABASE = "jdbc:postgresql://localhost:5432/webshop";
    private static final String DB_USER = "levente";
    private static final String DB_PASSWORD = "Savior0505";

    @Override
    public void getUser(String emailAddress) {
        String query = "SELECT * FROM \"users\"" +
                "WHERE email = '" + emailAddress + "';"  ;
        executeQuery(query);
    }

    @Override
    public void updateUser(User user) {
        String query = "UPDATE  \"users\"" +
                "SET name = '" + user.getName() + "'" +
                "WHERE email = '" + user.getEmailAddress() + "';";
        executeQuery(query);
    }

    @Override
    public void add(User user) {
        String query = "INSERT INTO \"users\" (name, email) VALUES ('" + user.getName() +
                "','" + user.getEmailAddress() + "');";
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
