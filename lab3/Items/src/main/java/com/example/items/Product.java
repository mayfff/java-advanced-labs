package com.example.items;

import com.example.annotations.*;
import lombok.AllArgsConstructor;

/**
 * This class contains fields for the product's name and price, and includes
 * validation to ensure that the name is not null and the price is within a specified range.
 * The validation logic can be performed both manually and using reflection with annotations.
 */
@AllArgsConstructor
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
}
