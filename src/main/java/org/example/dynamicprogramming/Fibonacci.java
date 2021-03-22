package org.example.dynamicprogramming;

/**
 * Created by ankouichi on 2/10/21
 */

public class Fibonacci {
    // Recursive Approach
    // Time: O(2^n)
    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    // Top-Down

    // Bottom-Up


    public static void main(String[] args) {
        System.out.println("Fibonacci of 6: " + fibonacci(6));
    }
}
