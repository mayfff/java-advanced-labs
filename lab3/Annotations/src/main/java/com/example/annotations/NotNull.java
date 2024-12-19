package com.example.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to specify that a field cannot be null.
 * This annotation can be applied to fields of any type to enforce that
 * their value must not be null.
 */
@Retention(RetentionPolicy.RUNTIME)  // Makes this annotation available at runtime via reflection
@Target(ElementType.FIELD)  // Can only be applied to fields
public @interface NotNull { }
