package com.example;

import com.example.items.*;

/**
 * Main class to demonstrate the usage of the Validator and validation process
 * for different objects (User, Product, and Order).
 * It compares the time taken for validation using reflection vs manual validation.
 */
public class Main {

    /**
     * Main method to run the validation for different objects.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        try {
            // Create a new User object with id, name, age, and email.
            User user = new User("1", "Alice", 25, "alice@email.com");
            // Create a new Product object with a name and price.
            Product product = new Product("Laptop", 9999);
            // Create a new Order object with an id, user id, and a description.
            Order order = new Order("ORD123", "4", "This is a test order.");

            // Validate the user object using Validator class.
            Validator.validate(user);
            // Validate the order object using Validator class.
            Validator.validate(order);
            // Validate the product object using Validator class.
            Validator.validate(product);

            // Indicate that all objects have passed validation.
            System.out.println("All objects are valid.");
        } catch (Exception e) {
            // Handle any validation errors and print the error message.
            System.err.println("Validation error: " + e.getMessage());
        }
    }
}