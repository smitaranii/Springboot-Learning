package com.smitarani.Week2.advices;

import lombok.Data;

import java.time.LocalDateTime;

// @Data generates getters, setters, toString, equals, and hashCode automatically
@Data
public class ApiResponse<T> {

    // timeStamp stores the exact time when the API response is created
    // Helpful for debugging and logging
    private LocalDateTime timeStamp;

    // data holds the successful response data from API
    // The generic type <T> allows it to hold any type of data (e.g., EmployeeDTO, List<EmployeeDTO>)
    private T data;

    // error holds an ApiError object if the API response is an error
    private ApiError error;

    // Default constructor initializes timeStamp to current time
    public ApiResponse() {
        this.timeStamp = LocalDateTime.now();
    }

    // Constructor for successful response with data
    public ApiResponse(T data) {
        this();  // Calls the default constructor to set timestamp
        this.data = data;
    }

    // Constructor for error response
    public ApiResponse(ApiError error) {
        this();  // Calls the default constructor to set timestamp
        this.error = error;
    }
}
