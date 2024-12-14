package annotations;

import java.lang.annotation.*;

/**
 * Annotation to specify that a field cannot be null.
 * This annotation can be applied to fields of any type to enforce that
 * their value must not be null.
 */
@Retention(RetentionPolicy.RUNTIME)  // Makes this annotation available at runtime via reflection
@Target(ElementType.FIELD)  // Can only be applied to fields
public @interface NotNull { }
