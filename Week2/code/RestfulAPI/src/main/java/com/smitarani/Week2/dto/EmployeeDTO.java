package com.smitarani.Week2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
// Used to control JSON serialization/deserialization.
// For example, we can change the JSON property name of a field.

import com.smitarani.Week2.annotations.EmployeeRoleValidation;
// Custom annotation we created to validate employee roles (ADMIN or USER).

import jakarta.validation.constraints.*;
// Contains built-in validation annotations for input validation.

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// Lombok annotations to reduce boilerplate code:
// @Getter/@Setter → automatically generate getter and setter methods
// @AllArgsConstructor → generate constructor with all fields
// @NoArgsConstructor → generate default constructor

import java.time.LocalDate;
// For storing date fields like date of joining.

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// These Lombok annotations save us from manually writing getters, setters, and constructors.

public class EmployeeDTO {

    private Long id;
    // Unique identifier for the employee. Not validated because it is auto-generated or managed.

    @NotBlank(message = "Name of the employee cannot be blank")
    // Ensures the name is not null or empty, and trimmed value is not empty.

    @Size(min = 3, max = 10, message = "Number of characters in name should be in the range: [3, 10]")
    // Ensures the length of name is between 3 and 10 characters.

    private String name;

    @NotBlank(message = "Email of the employee cannot be blank")
    // Email must not be empty.

    @Email(message = "Email should be a valid email")
    // Ensures the email follows a valid format like example@domain.com

    private String email;

    @NotNull(message = "Age of the employee cannot be blank")
    // Age must not be null.

    @Max(value = 80, message = "Age of Employee cannot be greater than 80")
    @Min(value = 18, message = "Age of Employee cannot be less than 18")
    // Age should be between 18 and 80.

    private Integer age;

    @NotBlank(message = "Role of the employee cannot be blank")
    // Role field cannot be empty.

    // @Pattern(regexp = "^(ADMIN|USER)$", message = "Role of Employee can either be USER or ADMIN")
    // Commented out because we are using a custom annotation below.

    @EmployeeRoleValidation
    // Custom annotation that checks if the role is either ADMIN or USER.

    private String role; //ADMIN, USER

    @NotNull(message = "Salary of Employee should be not null")
    // Salary must not be null.

    @Positive(message = "Salary of Employee should be positive")
    // Salary must be greater than 0.

    @Digits(integer = 6, fraction = 2, message = "The salary can be in the form XXXXX.YY")
    // Ensures that salary has up to 6 digits before decimal and 2 digits after decimal.

    @DecimalMax(value = "100000.99")
    @DecimalMin(value = "100.50")
    // Salary must be between 100.50 and 100000.99

    private Double salary;

    @PastOrPresent(message = "DateOfJoining field in Employee cannot be in the future")
    // Ensures date of joining is not in the future.

    private LocalDate dateOfJoining;

    @AssertTrue(message = "Employee should be active")
    // Boolean must be true. In this case, employee must be active.

    @JsonProperty("isActive")
    // The field will appear as "isActive" in JSON instead of "active".

    private Boolean isActive;
}
