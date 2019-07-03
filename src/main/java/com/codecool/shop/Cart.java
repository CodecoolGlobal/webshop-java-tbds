package com.codecool.shop;

import com.codecool.shop.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Product> productList = new ArrayList<>();

    public List<Product> getProductList() {
        return productList;

    }

    public void addProductToList(Product product) {
        productList.add(product);
    }

    public void removeProductfromList(Product product) {
        productList.remove(product);
    }
}
