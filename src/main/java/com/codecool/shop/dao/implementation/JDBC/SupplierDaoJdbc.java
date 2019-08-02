package com.codecool.shop.dao.implementation.JDBC;

import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.Supplier;
import com.codecool.shop.model.User;

import java.sql.*;
import java.util.List;

import static org.postgresql.jdbc2.EscapedFunctions.DATABASE;

public class SupplierDaoJdbc implements SupplierDao {
    private static final String DATABASE = "jdbc:postgresql://localhost:5432/webshop";
    private static final String DB_USER = "mate";
    private static final String DB_PASSWORD = "123";

    @Override
    public void add(Supplier supplier) {
        String query = "INSERT INTO supplier (name, description) VALUES ('" + supplier.getName()
                + "','" + supplier.getDescription() + "');";
        executeQuery(query);
    }

    @Override
    public void remove(int id) {
        String query = "DELETE FROM \"supplier\" WHERE id=" + id + ";";
        executeQuery(query);
    }

    @Override
    public List<Supplier> getAll() {
        String query = "SELECT * FROM \"supplier\"";
        executeQuery(query);
        return null;
    }

    @Override
    public Supplier find(int id) {
        String query = "SELECT * FROM \"supplier\" WHERE id=" + id + ";";
        executeQuery(query);
        return null;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                DATABASE,
                DB_USER,
                DB_PASSWORD);
    }

    private void executeQuery(String query) {
        try (Connection connection = getConnection();
             Statement statement =connection.createStatement()
        ){
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
