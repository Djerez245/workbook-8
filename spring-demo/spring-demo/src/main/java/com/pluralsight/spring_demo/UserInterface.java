package com.pluralsight.NorthwindTadersAPI;



import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UserInterface {

    Scanner scanner = new Scanner(System.in);
    ProductsDao pDao = new SimpleProductsDao();


    public void ui() {
        boolean running = true;
        while (running) {
            System.out.println("""
                    enter
                    1 to see all products
                    2 to add a product
                    3 to exit""");
            int input = scanner.nextInt();
            scanner.nextLine();
            switch (input){
                case 1: pDao.getAll();
                case 2: pDao.add(uiToGetProduct());
                case 3: running = false;
            }
        }
    }

    public Products uiToGetProduct(){
        System.out.print("enter product name: ");
        String name = scanner.nextLine();
        System.out.print("enter category: ");
        String category = scanner.nextLine();
        System.out.print("enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        Products p = new Products(0, name, category, price);
        return p;
    }
}
