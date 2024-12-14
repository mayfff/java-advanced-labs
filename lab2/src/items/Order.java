package items;

import annotations.*;

/**
 * This class contains fields for the order ID, customer ID, and a description of the order.
 * Validation annotations are applied to enforce constraints on these fields, such as ensuring
 * that the order and customer IDs are not null and that the description does not exceed a maximum length.
 */
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

    /**
     * Constructs a new Order with a specified order ID, customer ID, and description.
     *
     * @param orderID The unique identifier for the order.
     * @param customerID The unique identifier for the customer placing the order.
     * @param description A description of the order.
     */
    public Order(String orderID, String customerID, String description) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.description = description;
    }
}
