package com.smitarani.Week2.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// @Retention specifies how long the annotation is retained.
// RUNTIME means it is available at runtime for reflection (needed for validation)
@Retention(RetentionPolicy.RUNTIME)

// @Target specifies where the annotation can be applied
// FIELD → on class fields
// PARAMETER → on method parameters
@Target({ElementType.FIELD, ElementType.PARAMETER})

// @Constraint marks this annotation as a validation annotation
// 'validatedBy' tells Spring which class will handle the validation logic
@Constraint(validatedBy = {EmployeeRoleValidator.class})
public @interface EmployeeRoleValidation {

    // Default error message when validation fails
    String message() default "Role of Employee can either be USER or ADMIN";

    // Used for grouping constraints (advanced usage, usually leave empty)
    Class<?>[] groups() default {};

    // Payload can carry additional info about the validation failure
    // Usually leave as default
    Class<? extends Payload>[] payload() default {};
}
