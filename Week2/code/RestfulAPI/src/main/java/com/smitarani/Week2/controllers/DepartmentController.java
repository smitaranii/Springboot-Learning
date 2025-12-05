package com.smitarani.Week2.controllers;
import com.smitarani.Week2.dto.DepartmentDTO;
import com.smitarani.Week2.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    // GET all departments
    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
        return ResponseEntity.ok(service.getAllDepartments());
    }

    // GET department by ID
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Long id) {
        return service.getDepartmentById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + id));
    }

    // POST create department
    @PostMapping
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO dto) {
        DepartmentDTO saved = service.createDepartment(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // PUT update department
    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@PathVariable Long id, @RequestBody DepartmentDTO dto) {
        return ResponseEntity.ok(service.updateDepartment(id, dto));
    }

    // DELETE department
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteDepartment(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteDepartment(id));
    }
}
