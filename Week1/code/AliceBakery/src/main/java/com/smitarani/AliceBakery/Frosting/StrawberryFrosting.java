package com.smitarani.AliceBakery.Frosting;

/*
 * This class represents another frosting flavor:
 * → Strawberry Frosting
 *
 * It implements the Frosting interface, which means it provides
 * the specific behavior for getFrostingType().
 *
 * Spring will detect this class and treat it as a bean
 * because of the @Component annotation.
 */

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

// This tells Spring to only create this bean if the property "frost.flavour" is set to "strawberry"
@ConditionalOnProperty(name = "frost.flavour", havingValue = "strawberry")
@Component
/*
 * @Component
 * ----------
 * This marks the class as a Spring-managed bean.
 *
 * What does Spring do with @Component?
 * - Scans this class automatically (because of @SpringBootApplication)
 * - Creates an object of StrawberryFrosting
 * - Stores it in the Spring ApplicationContext
 *
 * Now Spring can inject StrawberryFrosting anywhere
 * a Frosting type is required.
 *
 * NOTE:
 * -----
 * Since ChocolateFrosting has @Primary,
 * CakeBaker will get ChocolateFrosting by default.
 *
 * But StrawberryFrosting is still available if:
 * - You use @Qualifier("strawberryFrosting"), or
 * - Inject a List<Frosting> or Map<String, Frosting>
 */

public class StrawberryFrosting implements Frosting {

    @Override
    /*
     * @Override
     * ----------
     * This ensures we are correctly implementing the method defined
     * in the Frosting interface.
     */
    public String getFrostingType() {

        // Return the flavor name used by CakeBaker when printing ingredients
        return "Strawberry Frosting";
    }
}
