package org.example.elementary.stackexample;

import java.util.Stack;

/**
 * Created by ankouichi on 1/28/21
 */

public class App {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack();
        System.out.println("The stack is empty? " + stack.empty());
        stack.push(1);
        stack.push(2);
        System.out.println("The stack size is: " + stack.size());
        System.out.println("The stack top is: " + stack.peek());
        stack.pop();
        System.out.println("The stack top is: " + stack.peek());

        String s = "123";
        System.out.println(Integer.parseInt(s));
    }
}
