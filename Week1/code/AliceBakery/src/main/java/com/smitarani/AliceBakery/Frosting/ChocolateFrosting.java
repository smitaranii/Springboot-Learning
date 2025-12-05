package com.smitarani.AliceBakery.Frosting;

/*
 * This class represents one type of frosting used in cakes:
 * → Chocolate Frosting
 *
 * It implements the Frosting interface, meaning it must define
 * the method getFrostingType().
 */

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// ChocolateFrosting implementation
//@Primary
/*
 * @Primary
 * ----------
 * When Spring sees multiple beans implementing the same interface
 * (in this case: Frosting), it doesn’t know which one to inject.
 *
 * Example:
 *    - ChocolateFrosting  (this class)
 *    - StrawberryFrosting
 *
 * @Primary tells Spring:
 *     "If someone needs a Frosting, choose THIS ONE by default."
 *
 * So CakeBaker will receive ChocolateFrosting unless another flavor
 * is explicitly specified using @Qualifier.
 */

// This tells Spring to only create this bean if the property "frost.flavour" is set to "chocolate"
@ConditionalOnProperty(name = "frost.flavour", havingValue = "chocolate")
@Component
/*
 * @Component
 * ----------
 * This marks the class as a Spring-managed bean.
 *
 * Because of @ComponentScan (triggered by @SpringBootApplication),
 * Spring will:
 *   ✓ Detect this class
 *   ✓ Create an object of ChocolateFrosting
 *   ✓ Store it inside the Spring container
 *
 * Later, Spring can inject it wherever a Frosting dependency is required.
 */

public class ChocolateFrosting implements Frosting {

    @Override
    /*
     * @Override
     * ----------
     * This confirms that this method is implementing the method
     * declared in the Frosting interface.
     */
    public String getFrostingType() {

        // Returns the type of frosting used by CakeBaker
        return "Chocolate Frosting ";
    }
}
