package com.smitarani.Week2.repositories;

import com.smitarani.Week2.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
    // JpaRepository provides all CRUD operations automatically
}
