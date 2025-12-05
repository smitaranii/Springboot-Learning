package com.smitarani.AliceBakery.Syrup;

/*
 * This class represents another type of syrup:
 * → Strawberry Syrup
 *
 * It implements the Syrup interface, meaning it provides a
 * specific flavor option that CakeBaker can use.
 */

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

// This tells Spring to only create this bean if the property "syrup.flavour" is set to "strawberry"
@ConditionalOnProperty(name = "syrup.flavour", havingValue = "strawberry")
@Component
/*
 * @Component
 * ----------
 * This tells Spring:
 *   "Create a Spring bean (object) of StrawberrySyrup and manage it."
 *
 * Because of @ComponentScan (enabled automatically by
 * @SpringBootApplication in the main class),
 * Spring detects this class and registers it in the application context.
 *
 * After this, StrawberrySyrup can be injected anywhere Spring needs a
 * Syrup dependency.
 *
 * In this project, Spring will NOT choose this by default,
 * because ChocolateSyrup has @Primary.
 * However, StrawberrySyrup is still available for use if required.
 */

public class StrawberrySyrup implements Syrup {

    @Override
    /*
     * @Override
     * ----------
     * Ensures this method correctly implements the method defined
     * in the Syrup interface.
     *
     * Helps catch errors at compile time.
     */
    public String getSyrupType() {

        // Return the type of syrup CakeBaker will print when baking
        return "Strawberry Syrup";
    }
}
