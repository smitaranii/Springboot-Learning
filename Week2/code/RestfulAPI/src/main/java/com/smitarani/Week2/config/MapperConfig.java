package com.smitarani.Week2.config;
// This package contains configuration-related classes for the application.

import org.modelmapper.ModelMapper;
// ModelMapper is a library used to map one object to another.
// Example: Converting Entity -> DTO or DTO -> Entity automatically.

import org.springframework.context.annotation.Bean;
// @Bean is used to tell Spring: "Create and manage this object"
// so you can use it anywhere using dependency injection.

import org.springframework.context.annotation.Configuration;
// @Configuration tells Spring that this class contains Beans or settings
// that should be added to the application context.

@Configuration
// This marks the class as a configuration class that will run
// when the application starts.

public class MapperConfig {

    @Bean
    // @Bean tells Spring Boot:
    // ➜ Create a single object (singleton) of ModelMapper
    // ➜ Store it in the Spring container
    // ➜ Make it available wherever we use @Autowired or constructor injection
    public ModelMapper getModelMapper() {
        return new ModelMapper();
        // Creating a ModelMapper object.
        // This will help us convert Entity ↔ DTO automatically
        // without manually setting each field.
    }
}
