package com.smitarani.AliceBakery;

// Importing the required libraries for testing
import org.junit.jupiter.api.Test; // Allows us to write test methods
import org.springframework.boot.test.context.SpringBootTest; // Helps load the Spring Boot application context for testing

// This annotation tells Spring Boot to look for the main configuration and start the application context for tests
@SpringBootTest
class AliceBakeryApplicationTests {

    // This annotation marks this method as a test method
    @Test
    void contextLoads() {
        // This test simply checks if the Spring Boot application context
        // starts correctly without any errors.
        // If the application fails to start, this test will fail.
    }
}
