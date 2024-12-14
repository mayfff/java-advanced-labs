package items;

import annotations.*;

/**
 * This class contains fields for the product's name and price, and includes
 * validation to ensure that the name is not null and the price is within a specified range.
 * The validation logic can be performed both manually and using reflection with annotations.
 */
public class Product {

    /**
     * The name of the product.
     * This field cannot be null, as indicated by the @NotNull annotation.
     */
    @NotNull
    private String name;

    /**
     * The price of the product.
     * This field must be between 0 and 10000, as indicated by the @MinValue and @MaxValue annotations.
     */
    @MinValue(0)
    @MaxValue(10000)
    private Integer price;

    /**
     * Constructs a new Product with a specified name and price.
     *
     * @param name The name of the product.
     * @param price The price of the product.
     */
    public Product(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Validates the product by checking that the name is not null and that the price is within the specified range.
     *
     * @throws IllegalArgumentException if the name is null or the price is outside the valid range (0 to 10000).
     */
    public void validate() {
        if (this.name == null) {
            throw new IllegalArgumentException("Product name cannot be null");
        }
        if (this.price < 0 || this.price > 10000) {
            throw new IllegalArgumentException("Product price must be between 0 and 10000");
        }
    }
}
