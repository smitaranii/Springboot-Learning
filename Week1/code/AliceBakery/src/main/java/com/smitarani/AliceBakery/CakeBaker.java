package com.smitarani.AliceBakery;

/*
 * This class represents the main "Cake Baker" in Alice Bakery.
 * It depends on two ingredients:
 *
 * 1) Frosting
 * 2) Syrup
 *
 * Both of these are interfaces, and Spring will inject their concrete
 * implementations automatically using Dependency Injection (DI).
 */

import com.smitarani.AliceBakery.Frosting.Frosting;
import com.smitarani.AliceBakery.Syrup.Syrup;
import org.springframework.stereotype.Component;

@Component
/*
 * @Component:
 * ------------
 * This tells Spring:
 * "Create an object (bean) of CakeBaker and manage it inside the Spring container."
 *
 * This allows Spring to:
 * - Detect this class automatically during component scanning
 * - Create only ONE object of CakeBaker (Singleton by default)
 * - Inject its required dependencies (Frosting and Syrup)
 *
 * Without @Component, Spring would NOT know this class exists,
 * and would NOT create or inject it.
 */
public class CakeBaker {

    /*
     * final keyword:
     * --------------
     * Means the field must be assigned once (in constructor)
     * and cannot be changed later.
     *
     * This ensures your dependencies are stable and not overwritten.
     *
     * These fields will hold the actual injected objects.
     */
    private final Frosting frosting;   // A Frosting bean will be injected
    private final Syrup syrup;         // A Syrup bean will be injected

    // ------------------------------------------------------------

    // Constructor-based Dependency Injection
    public CakeBaker(Frosting frosting, Syrup syrup) {

        /*
         * How DI works here:
         * ------------------
         * Spring sees that CakeBaker requires:
         * - a Frosting bean
         * - a Syrup bean
         *
         * So Spring looks inside the container and finds:
         *  Frosting → (e.g., ChocolateFrosting or StrawberryFrosting)
         *  Syrup    → (e.g., ChocolateSyrup or StrawberrySyrup)
         *
         * Then Spring automatically injects the selected implementations.
         */

        this.frosting = frosting;
        this.syrup = syrup;
    }

    // ------------------------------------------------------------

    // Method to bake a cake using the injected ingredients
    public void bakeCake() {
        /*
         * This method simply prints the ingredients used.
         *
         * The values of frosting.getFrostingType() and syrup.getSyrupType()
         * will depend on the actual implementation injected by Spring.
         *
         * Example:
         * If ChocolateFrosting and StrawberrySyrup are @Components,
         * output will be:
         *
         * Baking cake with :
         * Frosting--- Chocolate Frosting
         * Syrup--- Strawberry Syrup
         * Cake is ready !!
         */

        System.out.println("Baking cake with :");
        System.out.println("Frosting--- " + frosting.getFrostingType());
        System.out.println("Syrup--- " + syrup.getSyrupType());
        System.out.println("Cake is ready !!");
    }

}
