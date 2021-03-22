package org.example.elementary.IO;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by ankouichi on 1/24/21
 */

public class StringWriter {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("Foo.txt");
            fileWriter.write("This is the first line!");
            fileWriter.write("This is the second line!");
            fileWriter.write("This is the third line!");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
