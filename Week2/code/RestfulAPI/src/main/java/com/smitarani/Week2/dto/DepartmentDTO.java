package com.smitarani.Week2.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    private Long id;

    @NotBlank(message = "Department title cannot be blank")
    @Length(min = 2, max = 30, message = "Title must be between 2 and 30 characters")
    private String title;

    @NotNull(message = "Department active status must be specified")
    private Boolean isActive;

    @Range(min = 1, max = 100, message = "Department size must be between 1 and 100")
    @NotNull(message = "Department size must be specified")
    private Integer size;

    @PositiveOrZero(message = "Budget cannot be negative")
    @NotNull(message = "Budget must be specified")
    private Double budget;

    @DecimalMin(value = "1000.00", message = "Min allocation must be at least 1,000")
    @DecimalMax(value = "1000000.00", message = "Max allocation cannot exceed 1,000,000")
    @NotNull(message = "Allocation must be specified")
    private Double allocation;

    @Pattern(regexp = "HR|FINANCE|SALES|IT", message = "Department type must be one of HR, FINANCE, SALES, IT")
    @NotBlank(message = "Department type must be specified")
    private String departmentType;

    private LocalDateTime createdAt;  // This will be set in entity on persist
}
