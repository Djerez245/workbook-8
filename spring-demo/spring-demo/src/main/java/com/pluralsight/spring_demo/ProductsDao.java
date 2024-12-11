package com.pluralsight.NorthwindTadersAPI;

import java.util.List;

public interface ProductsDao {
    void add(Products products);
    List<Products> getAll();
}
