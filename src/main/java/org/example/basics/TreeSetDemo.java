package org.example.basics;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author: Daniel
 * @date: 2021/5/4 2:22
 * @description:
 * demo code for using java.util.TreeSet class
 * Time Complexity:
 *  add()      - log(n)
 *  remove()   - log(n)
 *  contains() - log(n)
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        charDemo();
        intDemo();
    }

    static void charDemo() {
        Set<Character> set = new TreeSet<>();
        set.add('A');
        set.add('B');
        set.add('C');
        set.add('C');
        System.out.println(set);
    }

    static void intDemo() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(3);
        set.add(2);
        set.add(1);
        set.add(1);
        System.out.println(set);
        System.out.println(set.contains(1));
        System.out.println(set.remove(1));
        System.out.println(set.contains(1));
        System.out.println(set.first());
        System.out.println(set.last());
    }
}
