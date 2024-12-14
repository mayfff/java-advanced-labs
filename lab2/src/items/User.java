package items;

import annotations.*;

/**
 * This class contains fields for the user's ID, name, age, and email, with validation constraints
 * applied through annotations. The ID and email cannot be null, the name must have a length between
 * 2 and 20 characters, and the age must be between 18 and 100.
 */
public class User {

    /**
     * The unique identifier for the user.
     * This field cannot be null, as indicated by the @NotNull annotation.
     */
    @NotNull
    private String id;

    /**
     * The name of the user.
     * The length of the name must be between 2 and 20 characters, as indicated by the @StringLength annotation.
     */
    @StringLength(min = 2, max = 20)
    private String name;

    /**
     * The age of the user.
     * This field must be between 18 and 100, as indicated by the @MinValue and @MaxValue annotations.
     */
    @MinValue(18)
    @MaxValue(100)
    private Integer age;

    /**
     * The email address of the user.
     * This field cannot be null, as indicated by the @NotNull annotation.
     */
    @NotNull
    private String email;

    /**
     * Constructs a new User with a specified ID, name, age, and email.
     *
     * @param id The unique identifier for the user.
     * @param name The name of the user.
     * @param age The age of the user.
     * @param email The email address of the user.
     */
    public User(String id, String name, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
