package com.smitarani.Week2.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

// This class contains the actual logic for validating the @EmployeeRoleValidation annotation
// It checks if the value of the field is either "USER" or "ADMIN"
public class EmployeeRoleValidator implements ConstraintValidator<EmployeeRoleValidation, String> {

    // This method is called by Spring to check if the field is valid
    // inputRole → the value of the field annotated with @EmployeeRoleValidation
    // constraintValidatorContext → provides context about the validation (can be used to customize messages)
    @Override
    public boolean isValid(String inputRole, ConstraintValidatorContext constraintValidatorContext) {
        // If the input is null, it's considered invalid
        if(inputRole == null) return false;

        // List of allowed roles
        List<String> roles = List.of("USER", "ADMIN");

        // Check if the input role exists in the allowed roles
        return roles.contains(inputRole);
    }
}
