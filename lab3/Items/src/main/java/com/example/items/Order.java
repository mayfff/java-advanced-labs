package com.example.items;

import com.example.annotations.*;
import lombok.AllArgsConstructor;

/**
 * This class contains fields for the order ID, customer ID, and a description of the order.
 * Validation annotations are applied to enforce constraints on these fields, such as ensuring
 * that the order and customer IDs are not null and that the description does not exceed a maximum length.
 */
@AllArgsConstructor
public class Order {
    /**
     * The unique identifier for the order.
     * This field cannot be null, as indicated by the @NotNull annotation.
     */
    @NotNull
    private String orderID;

    /**
     * The unique identifier for the customer who placed the order.
     * This field cannot be null, as indicated by the @NotNull annotation.
     */
    @NotNull
    private String customerID;

    /**
     * A description of the order.
     * This field cannot exceed 1000 characters, as indicated by the @StringLength annotation.
     */
    @StringLength(max = 1000)
    private String description;

}
