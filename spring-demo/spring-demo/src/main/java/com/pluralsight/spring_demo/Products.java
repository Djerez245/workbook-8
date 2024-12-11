package com.pluralsight.NorthwindTadersAPI;

public class Products {
    int productId;
    String name;
    String category;
    double price;

    public Products() {
    }

    public Products(int productId, String name, String category, double price) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return "Product{id=" + productId + ", name='" + name + "', category='" + category + "', price=" + price + "}";
    }
}
