package org.designpatterns.creational.singleton;

public class SingletonDemo {
    public static void main(String[] args) {
        SingleObjectEarly singleObjectEarly = SingleObjectEarly.getInstance();
        System.out.println("Early Instantiation Singleton:");
        singleObjectEarly.printSomething();

        System.out.println();
        SingleObjectLazy singleObjectLazy = SingleObjectLazy.getInstance();
        System.out.println("Lazy Instantiation Singleton:");
        singleObjectLazy.printSomething();
    }
}
