package org.example.elementary.IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by ankouichi on 1/24/21
 */

public class Deserialize {
    public static void main(String[] args) {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("dog.ser"));
            Object obj = inputStream.readObject();
            Dog dog = (Dog) obj;
            dog.bark();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException cne) {
            cne.printStackTrace();
        }
    }
}
