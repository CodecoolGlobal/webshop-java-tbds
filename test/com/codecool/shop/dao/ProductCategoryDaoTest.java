package com.codecool.shop.dao;

import com.codecool.shop.dao.implementation.JDBC.ProductCategoryDaoJdbc;
import com.codecool.shop.model.ProductCategory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductCategoryDaoTest {
    ProductCategoryDao testObject = new ProductCategoryDaoJdbc();

    @Test
    void add() {
        ProductCategory category = new ProductCategory("exName", "exDepo", "precise Desc");
        assertDoesNotThrow(()-> {
            testObject.add(category);
        });
    }

    @Test
    void find() {
        ProductCategory category = new ProductCategory("exName", "exDepo", "precise Desc");
        testObject.add(category);
        assertDoesNotThrow(()-> {
            testObject.find(1);
        });
    }
}