package com.smitarani.Week2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.smitarani.Week2.annotations.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;

    @NotBlank(message = "Name of the employee cannot be blank")
    @Size(min = 3, max = 50, message = "Number of characters in name should be in the range: [3, 50]")
    private String name;

    @NotBlank(message = "Email of the employee cannot be blank")
    @Email(message = "Email should be a valid email")
    private String email;

    @NotNull(message = "Age of the employee cannot be null")
    @Min(value = 18, message = "Age of Employee cannot be less than 18")
    @Max(value = 65, message = "Age of Employee cannot be greater than 65")
    private Integer age;

    @PastOrPresent(message = "DateOfJoining cannot be in the future")
    private LocalDate dateOfJoining;

    @Future(message = "Next appraisal date must be in the future")
    private LocalDate nextAppraisalDate;

    @AssertTrue(message = "Employee should be active")
    @JsonProperty("isActive")
    private Boolean isActive;

    @AssertFalse(message = "Employee should not be inactive")
    private Boolean isInactive;

    @NotBlank(message = "Department cannot be empty")
    private String department;

    @URL(message = "Profile URL must be valid")
    private String profileUrl;

    @CreditCardNumber(message = "Card number is invalid")
    private String creditCardNumber;

    @Negative(message = "Negative bonus must be negative")
    private Double negativeBonus;

    @NegativeOrZero(message = "Debt must be negative or zero")
    private Double debt;

    @PositiveOrZero(message = "Leave balance must be positive or zero")
    private Double leaveBalance;

    @Digits(integer = 5, fraction = 2, message = "Commission can have up to 5 digits and 2 decimals")
    private Double commission;

    @Range(min = 1, max = 10, message = "Performance rating must be between 1 and 10")
    private Integer performanceRating;

    @NotBlank(message = "Role cannot be blank")
    @EmployeeRoleValidation
    private String role;

    @NotNull(message = "Salary must not be null")
    @Positive(message = "Salary must be positive")
    @DecimalMin(value = "1000.00", message = "Salary cannot be less than 1,000")
    @DecimalMax(value = "100000.00", message = "Salary cannot exceed 100,000")
    private Double salary;
}
