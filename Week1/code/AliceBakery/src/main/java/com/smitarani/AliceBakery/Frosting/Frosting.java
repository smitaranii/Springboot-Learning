package com.smitarani.AliceBakery.Frosting;

/*
 * This file defines the FROSTING INTERFACE.
 *
 * What is an interface?
 * ---------------------
 * An interface is a contract that specifies:
 *   "Any class that implements me MUST provide these methods."
 *
 * In simple terms:
 *   - An interface tells WHAT must be done
 *   - The implementing classes decide HOW it should be done
 *
 * Why do we use an interface here?
 * --------------------------------
 * Because the bakery can have MANY types of frosting:
 *     - ChocolateFrosting
 *     - StrawberryFrosting
 *     - VanillaFrosting (future)
 *
 * The CakeBaker class should not depend on specific frosting classes.
 * Instead, it should depend on the general type "Frosting".
 *
 * This makes the system:
 *   ✔ Flexible
 *   ✔ Easy to extend
 *   ✔ Easy to maintain
 *   ✔ Suitable for Spring Dependency Injection
 *
 * Spring will inject whichever Frosting implementation is available.
 * If multiple exist, @Primary or @Qualifier chooses the correct one.
 */

// Interface to define frosting behavior
public interface Frosting {

    /*
     * This method MUST be implemented by every frosting type.
     *
     * Example implementations:
     * -------------------------
     * ChocolateFrosting  → return "Chocolate Frosting"
     * StrawberryFrosting → return "Strawberry Frosting"
     *
     * CakeBaker will call this method when printing the cake ingredients.
     */
    String getFrostingType(); // Returns type of frosting
}
