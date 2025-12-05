package com.smitarani.Week2.services;

import com.smitarani.Week2.dto.DepartmentDTO;
import com.smitarani.Week2.entities.DepartmentEntity;
import com.smitarani.Week2.exceptions.ResourceNotFoundException;
import com.smitarani.Week2.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository repository;
    private final ModelMapper mapper;

    public DepartmentService(DepartmentRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    // Get department by id
    public Optional<DepartmentDTO> getDepartmentById(Long id) {
        return repository.findById(id).map(dep -> mapper.map(dep, DepartmentDTO.class));
    }

    // Get all departments
    public List<DepartmentDTO> getAllDepartments() {
        return repository.findAll()
                .stream()
                .map(dep -> mapper.map(dep, DepartmentDTO.class))
                .collect(Collectors.toList());
    }

    // Create new department
    public DepartmentDTO createDepartment(DepartmentDTO dto) {
        DepartmentEntity department = mapper.map(dto, DepartmentEntity.class);
        DepartmentEntity saved = repository.save(department);
        return mapper.map(saved, DepartmentDTO.class);
    }

    // Update department by id
    public DepartmentDTO updateDepartment(Long id, DepartmentDTO dto) {
        DepartmentEntity department = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));

        department.setTitle(dto.getTitle());
        department.setIsActive(dto.getIsActive());
        department.setSize(dto.getSize());
        department.setBudget(dto.getBudget());
        department.setAllocation(dto.getAllocation());
        department.setDepartmentType(dto.getDepartmentType());

        DepartmentEntity updated = repository.save(department);
        return mapper.map(updated, DepartmentDTO.class);
    }
    

    // Delete department by id
    public boolean deleteDepartment(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Department not found with id: " + id);
        }
        repository.deleteById(id);
        return true;
    }
}
