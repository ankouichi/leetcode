package org.example.elementary.IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ankouichi on 1/24/21
 */

public class UseBuffer {
    public static void main(String[] args) {
        try {
            File file = new File("Foo.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String line = null;

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
