package com.codecool.shop;

import com.codecool.shop.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cart {

    private List<Product> productList = new ArrayList<>();
    private HashMap<Product,Integer> productIntegerHashMap = new HashMap<>();
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
