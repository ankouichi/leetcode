package org.designpatterns.behavioral.strategy;

/**
 * Strategy Pattern is also called Policy Pattern
 *
 * A strategy pattern says that "defines a family of functionality, encapsulate each one, and make them interchangeable."
 *
 * Benefits:
 * 1. it provides a substitute for subclassing
 * 2. it defines each behavior within its own class, eliminating the need for conditional statements
 * 3. it makes it easier to extend and incorporate new behavior without changing the application
 *
 * Usages:
 * 1. it is used when you need different algorithms
 * 2. when the multiple classes differ only in their behaviors. e.g. Servlet API
 *
 */

public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println("1.0 + 2.0 = " + context.executeStrategy(1,2));
        context = new Context(new OperationMultiply());
        System.out.println("3.0 * 5.0 = " + context.executeStrategy(3,5));
        context = new Context(new OperationSubtract());
        System.out.println("10.0 - 2.0 = " + context.executeStrategy(10,2));
    }
}
