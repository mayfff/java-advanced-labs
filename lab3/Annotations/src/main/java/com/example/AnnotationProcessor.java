package com.example;

import com.example.annotations.*;
import com.google.auto.service.AutoService;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.tools.Diagnostic;
import java.util.Set;

/**
 * A custom annotation processor that validates fields annotated with @MaxValue, @MinValue, @MinValue,
 * and @StringLength.
 */
@SupportedAnnotationTypes({
        "com.example.annotations.NotNull",
        "com.example.annotations.MaxValue",
        "com.example.annotations.MinValue",
        "com.example.annotations.StringLength"
})
@SupportedSourceVersion(SourceVersion.RELEASE_17)
@AutoService(Processor.class)
public class AnnotationProcessor extends AbstractProcessor {
    /**
     * A messager instance used to report errors, warnings, or notes during annotation processing.
     */
    private Messager messager;

    /**
     * Initializes the annotation processor with the provided {@link ProcessingEnvironment}.
     *
     * @param processingEnv the processing environment
     */
    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        messager = processingEnv.getMessager();
    }

    /**
     * Processes the annotated elements and validates them based on their annotations.
     *
     * @param annotations the set of annotations being processed
     * @param roundEnv    the environment for the current processing round
     * @return true if the annotations are claimed by this processor; false otherwise
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(NotNull.class)) {
            validateNotNull(element);
        }
        for (Element element : roundEnv.getElementsAnnotatedWith(MaxValue.class)) {
            validateMaxValue(element);
        }
        for (Element element : roundEnv.getElementsAnnotatedWith(MinValue.class)) {
            validateMinValue(element);
        }
        for (Element element : roundEnv.getElementsAnnotatedWith(StringLength.class)) {
            validateStringLength(element);
        }
        return true;
    }

    /**
     * Validates that the @NotNull annotation is correctly applied.
     *
     * @param element the element annotated with @NotNull
     */
    private void validateNotNull(Element element) {
        if (element.getKind() != ElementKind.FIELD) {
            messager.printMessage(Diagnostic.Kind.ERROR,
                    "Element is not a field",
                    element
            );
        } else {
            VariableElement variable = (VariableElement) element;

            if (variable.asType().getKind().isPrimitive()) {
                messager.printMessage(Diagnostic.Kind.NOTE,
                        "@NotNull couldn't be applied for field " + element.getSimpleName(),
                        element
                );
            }
        }
    }

    /**
     * Validates that the @MaxValue annotation is correctly applied.
     *
     * @param element the element annotated with @MaxValue
     */
    private void validateMaxValue(Element element) {
        if (element.getKind() != ElementKind.FIELD) {
            messager.printMessage(Diagnostic.Kind.ERROR,
                    "Element is not a field",
                    element
            );
        } else {
            String fieldType = element.asType().toString();

            if (!fieldType.equals("java.lang.Integer")) {
                messager.printMessage(Diagnostic.Kind.ERROR,
                        "@MaxValue could be applied only for Integer fields",
                        element
                );
            }
        }
    }

    /**
     * Validates that the @MinValue annotation is correctly applied.
     *
     * @param element the element annotated with @MinValue
     */
    private void validateMinValue(Element element) {
        if (element.getKind() != ElementKind.FIELD) {
            messager.printMessage(Diagnostic.Kind.ERROR,
                    "Element is not a field",
                    element
            );
        } else {
            String fieldType = element.asType().toString();

            if (!fieldType.equals("java.lang.Integer")) {
                messager.printMessage(Diagnostic.Kind.ERROR,
                        "@MinValue could be applied only for Integer fields",
                        element
                );
            }
        }
    }

    /**
     * Validates that the @StringLength}annotation is correctly applied.
     *
     * @param element the element annotated with @StringLength
     */
    private void validateStringLength(Element element) {
        if (element.getKind() != ElementKind.FIELD) {
            messager.printMessage(Diagnostic.Kind.ERROR,
                    "Element is not a field",
                    element
            );
        } else {
            String fieldType = element.asType().toString();

            if (!fieldType.equals("java.lang.String")) {
                messager.printMessage(Diagnostic.Kind.ERROR,
                        "@StringLength could be applied only for String fields",
                        element
                );
            }
        }
    }
}
