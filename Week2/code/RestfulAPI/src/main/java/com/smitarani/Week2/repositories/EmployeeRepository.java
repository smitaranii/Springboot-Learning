package com.smitarani.Week2.repositories;

import com.smitarani.Week2.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @Repository tells Spring that this interface is a Repository
// It will handle database operations and be a Spring-managed bean.
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    // Extending JpaRepository provides ready-made methods to interact with the database.
    // EmployeeEntity -> the entity class this repository manages
    // Long -> the type of the primary key in EmployeeEntity

    // Predefined methods available from JpaRepository:
    // save(entity) -> insert or update an entity
    // findById(id) -> find an entity by primary key
    // findAll() -> get all entities
    // deleteById(id) -> delete entity by primary key
    // count() -> get total number of entities

    // You can also define custom query methods here if needed
    // For example: List<EmployeeEntity> findByAgeGreaterThan(int age);
}
