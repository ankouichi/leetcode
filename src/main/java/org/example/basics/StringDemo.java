package org.example.basics;

import java.util.Objects;

public class StringDemo {
    public static void main(String[] args) {
        String s1 = "hello"; // string interned pool
        String s2 = "hello";
        String s3 = new String("hello");
        String s4 = "hello";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));
        System.out.println(Objects.equals(s1,s3));
    }
}
