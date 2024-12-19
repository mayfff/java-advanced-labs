package com.example.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to specify the minimum value allowed for a field.
 * This annotation can be used on fields of numeric types to enforce
 * a minimum value constraint.
 */
@Retention(RetentionPolicy.RUNTIME)  // Makes this annotation available at runtime via reflection
@Target(ElementType.FIELD)  // Can only be applied to fields
public @interface MinValue {
    // The minimum value allowed for the annotated field.
    int value();
}
