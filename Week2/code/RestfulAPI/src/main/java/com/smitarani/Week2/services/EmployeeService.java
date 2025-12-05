package com.smitarani.Week2.services;

import com.smitarani.Week2.dto.EmployeeDTO;
import com.smitarani.Week2.entities.EmployeeEntity;
import com.smitarani.Week2.exceptions.ResourceNotFoundException;
import com.smitarani.Week2.repositories.EmployeeRepository;
import org.apache.el.util.ReflectionUtil;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

// @Service tells Spring that this class is a "Service" component
// It contains business logic and can be injected into controllers or other classes.
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository; // Repository to interact with DB
    private final ModelMapper modelMapper; // Tool to convert between DTO and Entity

    // Constructor Injection is used to inject dependencies (Repository & ModelMapper)
    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    // Get employee by ID
    public Optional<EmployeeDTO> getEmployeeById(Long id) {
        // findById returns Optional<EmployeeEntity>
        // map() is used to convert EmployeeEntity to EmployeeDTO using ModelMapper
        return employeeRepository.findById(id)
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class));
    }

    // Get all employees
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll(); // Fetch all entities
        // Convert each entity to DTO using streams and ModelMapper
        return employeeEntities
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    // Create a new employee
    public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee) {
        // Convert DTO to Entity
        EmployeeEntity toSaveEntity = modelMapper.map(inputEmployee, EmployeeEntity.class);
        // Save to database
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(toSaveEntity);
        // Convert back to DTO and return
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }

    // Update an employee completely by ID (PUT operation)
    public EmployeeDTO updateEmployeeById(Long employeeId, EmployeeDTO employeeDTO) {
        isExistsByEmployeeId(employeeId); // Check if employee exists, else throw exception
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class); // Convert DTO to Entity
        employeeEntity.setId(employeeId); // Set the existing ID so it updates instead of creating new
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(employeeEntity); // Save updated entity
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class); // Convert back to DTO
    }

    // Helper method to check if employee exists by ID
    public void isExistsByEmployeeId(Long employeeId) {
        boolean exists = employeeRepository.existsById(employeeId);
        if (!exists) throw new ResourceNotFoundException("Employee not found with id: " + employeeId);
    }

    // Delete employee by ID
    public boolean deleteEmployeeById(Long employeeId) {
        isExistsByEmployeeId(employeeId); // Check if employee exists
        employeeRepository.deleteById(employeeId); // Delete from database
        return true;
    }

    // Update only certain fields of an employee (PATCH operation)
    public EmployeeDTO updatePartialEmployeeById(Long employeeId, Map<String, Object> updates) {
        isExistsByEmployeeId(employeeId); // Check if employee exists
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get(); // Get current entity

        // Loop through the map of fields and values to update
        updates.forEach((field, value) -> {
            // Find the field in EmployeeEntity class by name
            Field fieldToBeUpdated = ReflectionUtils.findRequiredField(EmployeeEntity.class, field);
            fieldToBeUpdated.setAccessible(true); // Allow modification of private fields
            ReflectionUtils.setField(fieldToBeUpdated, employeeEntity, value); // Set new value
        });

        // Save the updated entity to DB and return as DTO
        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }
}
