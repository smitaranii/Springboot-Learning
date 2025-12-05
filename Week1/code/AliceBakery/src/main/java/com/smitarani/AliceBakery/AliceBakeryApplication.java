package com.smitarani.AliceBakery;

/*
 * This is the MAIN Spring Boot application class.
 *
 * In a Spring Boot project, this class does three important things:
 * 1. Tells Spring Boot to start the application.
 * 2. Enables auto-configuration.
 * 3. Triggers component scanning so Spring can find @Component classes.
 */

import org.springframework.boot.CommandLineRunner;           // Interface used to run code after startup
import org.springframework.boot.SpringApplication;         // Responsible for starting the Spring application
import org.springframework.boot.autoconfigure.SpringBootApplication; // Main Boot annotation
import org.springframework.context.annotation.Bean;         // Used to create custom beans manually

@SpringBootApplication
/*
 * @SpringBootApplication is a combination of three annotations:
 *
 * 1) @Configuration
 *    - Marks this class as a Spring configuration class.
 *    - It can define @Bean methods.
 *
 * 2) @EnableAutoConfiguration
 *    - Spring Boot automatically configures beans based on dependencies.
 *    - Example: If you add spring-web, it configures DispatcherServlet automatically.
 *
 * 3) @ComponentScan
 *    - Spring scans the current package and all sub-packages to find:
 *         @Component
 *         @Service
 *         @Repository
 *         @Controller
 *       and creates beans for them.
 *
 * Because of this annotation, Spring knows to scan:
 * com.smitarani.AliceBakery.*
 * for components like CakeBaker, Frosting implementations, Syrup implementations, etc.
 */
public class AliceBakeryApplication {

    public static void main(String[] args) {
        /*
         * SpringApplication.run():
         * - Starts Spring Boot application.
         * - Creates ApplicationContext (Spring container).
         * - Performs component scanning.
         * - Applies auto-configuration.
         * - Creates all beans and injects dependencies.
         * - Finally runs CommandLineRunner beans.
         */
        SpringApplication.run(AliceBakeryApplication.class, args);
    }

    /*
     * @Bean → This method will produce a bean that Spring manages.
     *
     * Here we are creating a CommandLineRunner bean.
     *
     * CommandLineRunner:
     * - Runs automatically after the application starts.
     * - Useful for testing beans, running sample logic, seeding data, etc.
     *
     * Spring will inject CakeBaker (Autowired automatically) into this method.
     */
    @Bean
    CommandLineRunner run(CakeBaker cakeBaker) {
        /*
         * This returns a lambda expression: args -> { ... }
         *
         * Meaning: When the application starts, run this code.
         *
         * Inside we call cakeBaker.bakeCake()
         * which uses DI to produce output like:
         * "Baking cake with Chocolate Frosting and Strawberry Syrup"
         */
        return args -> {
            cakeBaker.bakeCake();
        };
    }

}
