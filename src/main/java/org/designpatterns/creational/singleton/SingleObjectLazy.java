package org.designpatterns.creational.singleton;

public class SingleObjectLazy {
    private static SingleObjectLazy instance;
    private SingleObjectLazy() {
    }

    public static SingleObjectLazy getInstance() {
        if (instance == null) {
            synchronized(SingleObjectLazy.class) {
                if (instance == null)
                    instance = new SingleObjectLazy(); //instance will be created at request time
            }
        }

        return instance;
    }

    public void printSomething() {
        System.out.println("Hello Singleton.");
    }
}
