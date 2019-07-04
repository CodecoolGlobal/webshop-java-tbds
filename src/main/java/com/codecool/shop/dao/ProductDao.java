package com.codecool.shop.dao;

import com.codecool.shop.model.Supplier;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;

import java.util.List;

public interface ProductDao {

    void add(Product product);
    Product find(int id);
    void remove(int id);

    List<Product> getAll();
    List<Product> getBy(Supplier supplier);
    List<Product> getBy(ProductCategory productCategory);
    List<Product> getByBoth(ProductCategory productCategory, Supplier supplier);

    default List<Product> getBy(ProductCategory productCategory, Supplier supplier) {
        if (productCategory == null && supplier == null){
            return getAll();
        }

        if (productCategory == null){
            return getBy(supplier);
        }

        if (supplier == null){
            return getBy(productCategory);
        }

        return getByBoth(productCategory, supplier);
    }
}
