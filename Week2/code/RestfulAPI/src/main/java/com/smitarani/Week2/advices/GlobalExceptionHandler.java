package com.smitarani.Week2.advices;

import com.smitarani.Week2.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

// @RestControllerAdvice is a special annotation in Spring Boot
// It allows this class to **handle exceptions globally** for all REST controllers
@RestControllerAdvice
public class GlobalExceptionHandler {

    // This method handles custom ResourceNotFoundException
    // Whenever this exception is thrown in your app, this method will be called
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleResourceNotFound(ResourceNotFoundException exception) {
        // Build a structured ApiError object
        ApiError apiError = ApiError.builder()
                .status(HttpStatus.NOT_FOUND)   // HTTP 404
                .message(exception.getMessage()) // Exception message
                .build();
        return buildErrorResponseEntity(apiError); // Wrap ApiError in ApiResponse and return
    }

    // This method handles any generic exceptions that are not specifically caught
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleInternalServerError(Exception exception) {
        ApiError apiError = ApiError.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR) // HTTP 500
                .message(exception.getMessage())          // Exception message
                .build();
        return buildErrorResponseEntity(apiError); // Wrap and return
    }

    // This method handles validation errors when @Valid fails in DTOs
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleInputValidationErrors(MethodArgumentNotValidException exception) {
        // Collect all validation error messages from the exception
        List<String> errors = exception
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage()) // Get readable message for each error
                .collect(Collectors.toList());

        // Create ApiError object for validation errors
        ApiError apiError = ApiError.builder()
                .status(HttpStatus.BAD_REQUEST) // HTTP 400
                .message("Input validation failed")
                .subErrors(errors)              // Attach detailed list of validation messages
                .build();
        return buildErrorResponseEntity(apiError); // Wrap and return
    }

    // Helper method to create a ResponseEntity containing ApiResponse
    // Ensures all error responses have consistent structure
    private ResponseEntity<ApiResponse<?>> buildErrorResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(new ApiResponse<>(apiError), apiError.getStatus());
    }
}
