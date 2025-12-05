package com.smitarani.Week2.controllers;
// This package stores all controller classes (classes that handle API requests)

import com.smitarani.Week2.dto.EmployeeDTO;
import com.smitarani.Week2.entities.EmployeeEntity;
import com.smitarani.Week2.exceptions.ResourceNotFoundException;
import com.smitarani.Week2.repositories.EmployeeRepository;
import com.smitarani.Week2.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
// @RestController = This class will handle REST API calls and return JSON responses.

@RequestMapping(path = "/employees")
// @RequestMapping = Sets a base URL for all APIs inside this class.
// Every endpoint in this controller will start with: /employees

public class EmployeeController {

    // This is the Service layer object.
    // Service layer contains business logic (create, update, delete employee etc.)
    private final EmployeeService employeeService;

    // Constructor Injection
    // Spring automatically injects the EmployeeService object here.
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // ---------------- GET EMPLOYEE BY ID ----------------

    @GetMapping(path = "/{employeeId}")
    // @GetMapping = Handles HTTP GET requests.
    // /{employeeId} means it will read the employeeId from the URL. Example: /employees/5
    public ResponseEntity<EmployeeDTO> getEmployeeById(
            @PathVariable(name = "employeeId") Long id) {
        // @PathVariable = Extracts the variable from the URL and stores it in 'id'.

        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(id);
        // Calls the service layer to fetch employee by ID.
        // May return empty if employee does not exist → Optional handles that.

        return employeeDTO
                .map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
                // If value is found → return 200 OK with the employee data.
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        // If not found → throw custom exception (handled by GlobalExceptionHandler)
    }

    // ---------------- GET ALL EMPLOYEES ----------------

    @GetMapping
    // Handles GET request for /employees (fetch all employees)
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(
            @RequestParam(required = false, name = "inputAge") Integer age,
            // @RequestParam = Reads query parameter from URL.
            // Example: /employees?inputAge=25

            @RequestParam(required = false) String sortBy) {
        // Example: /employees?sortBy=name

        return ResponseEntity.ok(employeeService.getAllEmployees());
        // Returning 200 OK with list of employees
    }

    // ---------------- CREATE NEW EMPLOYEE ----------------

    @PostMapping
    // @PostMapping = Handles POST request (used for creating new data)
    public ResponseEntity<EmployeeDTO> createNewEmployee(
            @RequestBody @Valid EmployeeDTO inputEmployee) {
        // @RequestBody = Converts incoming JSON to EmployeeDTO object.
        // @Valid = Runs validation on EmployeeDTO fields before saving.

        EmployeeDTO savedEmployee = employeeService.createNewEmployee(inputEmployee);
        // Calls service to save the new employee.

        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
        // ResponseEntity with status 201 = CREATED (successful creation)
    }


    // ---------------- UPDATE FULL EMPLOYEE ----------------

    @PutMapping(path = "/{employeeId}")
    // @PutMapping = Used for full update (replace entire object)
    public ResponseEntity<EmployeeDTO> updateEmployeeById(
            @RequestBody @Valid EmployeeDTO employeeDTO,
            @PathVariable Long employeeId) {
        // Takes updated data from body + ID from path

        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeId, employeeDTO));
        // Returns updated employee with 200 OK
    }

    // ---------------- DELETE EMPLOYEE ----------------

    @DeleteMapping(path = "/{employeeId}")
    // @DeleteMapping = Used to delete data
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long employeeId) {

        boolean gotDeleted = employeeService.deleteEmployeeById(employeeId);
        // Service layer deletes the employee and returns true/false

        if (gotDeleted) return ResponseEntity.ok(true);
        // If deleted → return 200 OK with true

        return ResponseEntity.notFound().build();
        // If employee not found → return 404 Not Found
    }

    // ---------------- PARTIAL UPDATE ----------------

    @PatchMapping(path = "/{employeeId}")
    // @PatchMapping = Used for partial update (ex: update only age or only name)
    public ResponseEntity<EmployeeDTO> updatePartialEmployeeById(
            @RequestBody Map<String, Object> updates,
            // Map<String, Object> = you can send only the fields you want to update
            // Example: { "age": 30 }

            @PathVariable Long employeeId) {

        EmployeeDTO employeeDTO = employeeService.updatePartialEmployeeById(employeeId, updates);
        // Service layer applies the partial update

        if (employeeDTO == null) return ResponseEntity.notFound().build();
        // If employee not found → return 404

        return ResponseEntity.ok(employeeDTO);
        // Else return updated employee with 200 OK
    }

}
