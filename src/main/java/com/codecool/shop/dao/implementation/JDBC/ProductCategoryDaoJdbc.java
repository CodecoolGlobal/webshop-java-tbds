package com.codecool.shop.dao.implementation.JDBC;

import com.codecool.shop.Global;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.model.ProductCategory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class ProductCategoryDaoJdbc implements ProductCategoryDao {
    private static final String DATABASE = "jdbc:postgresql://localhost:5432/webshop";
    private static final String DB_USER = "levente";
    private static final String DB_PASSWORD = "Savior0505";

    Global global = Global.getInstance();
    @Override
    public void add(ProductCategory category) { // todo: fix names like SQL table
        String query = "INSERT INTO product_category" +
                "(name, description, department)" +
                "VALUES ("+ category.getName()+","+category.getDescription()+
                ", "+category.getDepartment()+");";
        //global.executeQuery(query,statement -> { statement.setString(1, id); });

    }

    @Override
    public ProductCategory find(int id) {
        String query = "SELECT * from product_category" +
                "WHERE id= '" + id + "' ;";
        executeQuery(query);
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<ProductCategory> getAll() {
        return null;
    }

    @Override
    public ProductCategory findByName(String categoryName) {
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
