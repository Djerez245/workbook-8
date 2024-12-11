package com.pluralsight.NorthwindTadersAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;


public class NorthwindApplication implements CommandLineRunner {

    @Autowired
    private ProductsDao productsDao;

    @Autowired
    private UserInterface userInterface;

    public static void main(String[] args) {
        SpringApplication.run(NorthwindApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userInterface.ui();
    }
}
