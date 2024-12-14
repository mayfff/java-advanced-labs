import annotations.*;
import java.lang.reflect.*;

/**
 * This class uses reflection to inspect the fields of an object and apply the validation rules
 * defined by the annotations @NotNull, @StringLength, @MinValue, and @MaxValue.
 * If a field does not satisfy the constraints defined by these annotations, an IllegalArgumentException
 * is thrown.
 */
public class Validator {

    /**
     * This method checks each field of the given object for the presence of validation annotations,
     * and performs the corresponding validation logic. If any field fails the validation, an exception
     * is thrown with a detailed message.
     *
     * @param obj The object to validate.
     * @throws IllegalAccessException If the field is not accessible.
     * @throws IllegalArgumentException If any of the fields fail validation.
     */
    public static void validate(Object obj) throws IllegalAccessException {
        // Get the class of the object being validated
        Class<?> clazz = obj.getClass();

        // Iterate over all fields of the class
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true); // Make private fields accessible

            // Get the value of the field for validation
            Object value = field.get(obj);

            // Validate the field if it has the @NotNull annotation
            if (field.isAnnotationPresent(NotNull.class) && value == null) {
                throw new IllegalArgumentException("Class: " + clazz.getSimpleName() + ". Field " + field.getName() + " cannot be null");
            }

            // Validate the field if it has the @StringLength annotation
            if (field.isAnnotationPresent(StringLength.class)) {
                if (value instanceof String str) {
                    StringLength annotation = field.getAnnotation(StringLength.class);
                    if (str.length() < annotation.min() || str.length() > annotation.max()) {
                        throw new IllegalArgumentException("Class: " + clazz.getSimpleName() + ". Field " + field.getName() + " length must be between " + annotation.min() + " and " + annotation.max());
                    }
                } else {
                    throw new IllegalArgumentException("@StringLength can only be applied to String fields. Field: " + field.getName() + " is not a String");
                }
            }

            // Validate the field if it has the @MinValue annotation
            if (field.isAnnotationPresent(MinValue.class)) {
                if (value instanceof Integer intValue) {
                    MinValue annotation = field.getAnnotation(MinValue.class);
                    if (intValue < annotation.value()) {
                        throw new IllegalArgumentException("Class: " + clazz.getSimpleName() + ". Field " + field.getName() + " must be greater than or equal to " + annotation.value());
                    }
                } else {
                    throw new IllegalArgumentException("@MinValue can only be applied to Integer fields. Field: " + field.getName() + " is not an Integer");
                }
            }

            // Validate the field if it has the @MaxValue annotation
            if (field.isAnnotationPresent(MaxValue.class)) {
                if (value instanceof Integer intValue) {
                    MaxValue annotation = field.getAnnotation(MaxValue.class);
                    if (intValue > annotation.value()) {
                        throw new IllegalArgumentException("Class: " + clazz.getSimpleName() + ". Field " + field.getName() + " must be less than or equal to " + annotation.value());
                    }
                }
            }
        }
    }
}
