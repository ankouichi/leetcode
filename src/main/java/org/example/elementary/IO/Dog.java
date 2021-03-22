package org.example.elementary.IO;

import java.io.Serializable;

/**
 * Created by ankouichi on 1/24/21
 */

public class Dog implements Serializable {
    private String breed;
    static int legs = 4;
    public Dog(String breed) {
        this.breed = breed;
    }
    public void bark() {
        System.out.println("This is a " + breed);
    }
}
