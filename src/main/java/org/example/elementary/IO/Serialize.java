package org.example.elementary.IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by ankouichi on 1/24/21
 */

public class Serialize {
    public static void main(String[] args) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("dog.ser"));
            Dog dog = new Dog("corgi");
            outputStream.writeObject(dog);
            outputStream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}


