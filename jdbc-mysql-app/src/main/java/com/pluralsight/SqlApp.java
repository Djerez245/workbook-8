package com.pluralsight;

import java.sql.*;

public class SqlApp {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/cardealership";
        String user = "root" ;
        String password = "yearup";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            Statement statement = connection.createStatement();
            statement.executeQuery("select * from vehicles;");

            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()){
                String make = resultSet.getString("make");
                String model = resultSet.getString("model");
                double price = resultSet.getDouble("price");
                System.out.printf("make: %s model: %s Price: $%.2f\n", make, model, price);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
