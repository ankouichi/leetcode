package org.designpatterns.creational.singleton;

public class SingleObjectEarly {
    private static final SingleObjectEarly instance = new SingleObjectEarly(); //Early, instance will be created at load time
    private SingleObjectEarly() {
    }

    public static SingleObjectEarly getInstance() {
        return instance;
    }

    public void printSomething() {
        System.out.println("Hello Singleton.");
    }
}
