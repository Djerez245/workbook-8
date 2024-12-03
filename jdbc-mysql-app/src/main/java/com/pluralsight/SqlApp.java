package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.Scanner;

public class SqlApp {

    public static void main(String[] args) {

        BasicDataSource dataSource;
        dataSource = new BasicDataSource();

        String url = "jdbc:mysql://localhost:3306/cardealership";
        dataSource.setUrl(url);
        dataSource.setUsername(args[0]);
        dataSource.setPassword(args[1]);
        Scanner scanner = new Scanner(System.in);

        try (Connection connection = dataSource.getConnection()) {

            PreparedStatement statement = connection.prepareStatement("select * from vehicles where make = ?;");

            boolean running = true;
            while (running) {
                System.out.print("Enter a vehicle by make: ");
                String command = scanner.nextLine();

                statement.setString(1, command);
                statement.execute();

                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    String make = resultSet.getString("make");
                    String model = resultSet.getString("model");
                    double price = resultSet.getDouble("price");
                    System.out.printf("make: %s model: %s Price: $%.2f\n", make, model, price);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            dataSource.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

