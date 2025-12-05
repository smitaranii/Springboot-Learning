package com.smitarani.AliceBakery.Syrup;

/*
 * This class represents one type of syrup used in cakes:
 * → Chocolate Syrup
 *
 * It implements the Syrup interface, meaning it provides
 * the actual behavior for getSyrupType().
 *
 * Spring will treat this as a bean and inject it wherever
 * a Syrup dependency is required.
 */

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// This tells Spring to only create this bean if the property "syrup.flavour" is set to "chocolate"
@ConditionalOnProperty(name = "syrup.flavour", havingValue = "chocolate")
@Component
/*
 * @Component
 * ----------
 * This annotation tells Spring:
 *   "Create an object of ChocolateSyrup and manage it as a bean."
 *
 * Because of @ComponentScan (enabled by @SpringBootApplication),
 * Spring will automatically detect this class, create an instance,
 * and store it in the application context.
 *
 * This allows Spring to inject ChocolateSyrup into CakeBaker automatically.
 */

//@Primary
/*
 * @Primary
 * ----------
 * Why do we need it?
 * If we have multiple beans implementing the same interface (Syrup),
 * for example:
 *   - ChocolateSyrup
 *   - StrawberrySyrup
 *
 * Then Spring gets confused:
 *   "Which Syrup bean should I inject?"
 *
 * @Primary solves this by marking ONE bean as the default choice.
 *
 * So if CakeBaker requires a Syrup:
 *     public CakeBaker(Frosting f, Syrup syrup)
 *
 * Spring will choose ChocolateSyrup by default.
 */

public class ChocolateSyrup implements Syrup {

    @Override
    /*
     * @Override
     * ----------
     * This annotation ensures that this method is actually overriding
     * a method from the Syrup interface.
     *
     * It helps catch errors at compile time.
     */
    public String getSyrupType() {
        // Returns this syrup’s name when called by CakeBaker
        return "Chocolate Syrup";
    }
}
