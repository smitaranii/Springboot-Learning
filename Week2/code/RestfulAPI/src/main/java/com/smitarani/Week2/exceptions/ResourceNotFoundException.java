package com.smitarani.Week2.exceptions;

// Custom exception class for handling cases when a requested resource is not found.

public class ResourceNotFoundException extends RuntimeException {
    // Extending RuntimeException allows us to throw this exception without explicitly declaring it in method signatures.

    public ResourceNotFoundException(String message) {
        // Constructor takes a message parameter, which describes the reason for the exception.
        super(message);
        // Passes the message to the parent RuntimeException class.
    }
}
