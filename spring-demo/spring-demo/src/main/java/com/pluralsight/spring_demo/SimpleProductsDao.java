package com.pluralsight.NorthwindTadersAPI;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class SimpleProductsDao implements ProductsDao {
    private HashMap<Integer, Products> hashMap;
    private Integer counter = 5;

    public SimpleProductsDao() {
        this.hashMap = new HashMap<Integer, Products>();

        this.hashMap.put(20, new Products(1, "samsungTV", "electronics", 500.00));
        this.hashMap.put(10, new Products(2, "laptop", "electronics", 800.00));
        this.hashMap.put(15, new Products(3, "coke", "drinks", 2.00));
        this.hashMap.put(30, new Products(4, "sprite", "drinks", 2.00));
    }

    @Override
    public void add(Products products) {
        int freshId = counter++;
        this.hashMap.put(freshId, new Products(freshId, products.getName(), products.getCategory(), products.getPrice()));

    }

    @Override
    public List<Products> getAll() {
        List<Products> productsList = new ArrayList<>(hashMap.values());
        for (Products p : productsList) {
            System.out.println(p);
        }
        return productsList;
    }
}



