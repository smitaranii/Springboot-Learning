package com.smitarani.Week2.advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

// @Data from Lombok automatically generates getters, setters, toString, equals, and hashCode methods
@Data

// @Builder allows you to create objects of this class using the builder pattern
// Example: ApiError.builder().status(...).message(...).subErrors(...).build();
@Builder
public class ApiError {

    // HttpStatus holds the HTTP response status (e.g., 404 NOT FOUND, 400 BAD REQUEST)
    private HttpStatus status;

    // message is the main error message explaining what went wrong
    private String message;

    // subErrors is a list of detailed error messages (useful when multiple validation errors occur)
    private List<String> subErrors;

}
