package annotations;

import java.lang.annotation.*;

/**
 * Annotation to specify the minimum and maximum length constraints for a string field.
 * This annotation can be applied to fields of type String to enforce length constraints.
 */
@Retention(RetentionPolicy.RUNTIME)  // Makes this annotation available at runtime via reflection
@Target(ElementType.FIELD)  // Can only be applied to fields
public @interface StringLength {
    // The minimum length of the string.
    int min() default 0;
    // The maximum length of the string.
    int max() default Integer.MAX_VALUE;
}
