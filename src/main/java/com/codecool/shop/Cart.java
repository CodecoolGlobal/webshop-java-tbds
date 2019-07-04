package com.codecool.shop;

import com.codecool.shop.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cart {
    private int quanity = 1;

    //private HashMap<Product,Integer> productIntegerHashMap = new HashMap<>();
    private ArrayList<Product> productsList = new ArrayList<>();
    private ArrayList<Integer> quanityList = new ArrayList<>();

    public ArrayList<Product> getProductList() {
        return productsList;
    }

    public ArrayList<Integer> getQuanityList() {
        return quanityList;
    }

    public int getProductQuanity(Product product){
        for (int i=0;i<productsList.size();i++){
            if(productsList.get(i).equals(product)){
                return quanityList.get(i);
            }
        }
        return -1;
    }

    public void addProductToList(Product product) {
        if(productsList.contains(product)){
            for (int i=0;i<productsList.size();i++){
                if (productsList.get(i).equals(product)){
                    quanityList.set(i,getProductQuanity(product) + 1);
                }}
        }else {
            productsList.add(product);
            quanityList.add(1);
            System.out.println("quanity:1");
        }
    }

    public void removeProductfromList(Product product) {
        for (int i = 0; i < productsList.size(); i++) {
            if(productsList.get(i).equals(product)){
                productsList.remove(product);
                quanityList.remove(i);
            }
        }
    }
}
