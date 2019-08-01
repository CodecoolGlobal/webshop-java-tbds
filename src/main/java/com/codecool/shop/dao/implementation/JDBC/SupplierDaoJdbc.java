package com.codecool.shop.dao.implementation.JDBC;

import com.codecool.shop.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.postgresql.jdbc2.EscapedFunctions.DATABASE;

public class SupplierDaoJdbc {
    private static final String DATABASE = "jdbc:postgresql://localhost:5432/webshop";
    private static final String DB_USER = "mate";
    private static final String DB_PASSWORD = "123";

    @Override
    public void add() {
        String query = "INSERT INTO \"\" (name, email) VALUES ('" +  +
                "','" +  + "');";
        executeQuery(query);
    }

    @Override
    public void remove(int id) {
        String query = "DELETE FROM table WHERE " + id + " ";
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
