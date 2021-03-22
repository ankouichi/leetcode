package org.example.elementary.stringformat;

/**
 * Created by ankouichi on 1/23/21
 */

public class NumberFormat {

    public static void main(String[] args) {
        String s = String.format("%, d", 100000000);
        String f = String.format("%,10.2f", 3333.1415926);
        System.out.println(s);
        System.out.println(f);
    }
}
