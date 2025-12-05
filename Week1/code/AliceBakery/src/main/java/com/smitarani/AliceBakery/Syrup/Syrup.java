package com.smitarani.AliceBakery.Syrup;

/*
 * This file defines the SYRUP INTERFACE for the bakery system.
 *
 * What is an interface?
 * ---------------------
 * An interface is like a contract that says:
 *    "Any class that implements me MUST provide these methods."
 *
 * In this case, the contract is:
 *    Every Syrup must tell what type of syrup it is.
 *
 * Why use an interface here?
 * --------------------------
 * 1. We can create multiple syrup flavors:
 *      - ChocolateSyrup
 *      - StrawberrySyrup
 *
 * 2. CakeBaker does NOT depend on a specific syrup type.
 *    It depends only on the Syrup interface.
 *
 * This makes the design flexible and scalable.
 *
 * If tomorrow Alice wants Mango Syrup,
 * you only create MangoSyrup implements Syrup — no other code changes!
 */

// Interface to define Syrup behavior
public interface Syrup {

    /*
     * This method must be implemented by every syrup type.
     *
     * Example Implementations:
     * ------------------------
     * ChocolateSyrup → returns "Chocolate Syrup"
     * StrawberrySyrup → returns "Strawberry Syrup"
     *
     * CakeBaker uses this method to print syrup type while baking.
     */
    String getSyrupType(); // Returns type of Syrup
}
