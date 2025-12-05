package com.smitarani.Week2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Integer age;

    private LocalDate dateOfJoining;

    private LocalDate nextAppraisalDate;

    @Column(nullable = false)
    private Boolean isActive;

    private Boolean isInactive;

    @Column(nullable = false)
    private String department;

    private String profileUrl;

    private String creditCardNumber;

    private Double negativeBonus;

    private Double debt;

    private Double leaveBalance;

    private Double commission;

    private Integer performanceRating;

    private String role;

    @Column(nullable = false)
    private Double salary;
}
