package com.example.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to specify the maximum value allowed for a field.
 * This annotation can be used on fields of numeric types to enforce
 * a maximum value constraint.
 */
@Retention(RetentionPolicy.RUNTIME) // Makes this annotation available at runtime
@Target(ElementType.FIELD) // Can only be applied to fields
public @interface MaxValue {
    // The maximum value allowed for the annotated field.
    int value();
}
