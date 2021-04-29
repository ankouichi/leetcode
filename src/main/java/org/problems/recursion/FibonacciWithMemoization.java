package org.problems.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Daniel
 * @date: 2021/4/13 1:53
 * @description:
 */
public class FibonacciWithMemoization {
    public static int fibonacci(int n) {
        if (n < 2) {
            return n;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

    private static final Map<Integer, Integer> cache = new HashMap<>();

    public static int fibonacci2(int n) {
        if (cache.containsKey(n)) return cache.get(n);
        if (n < 2) return n;
        int result = fibonacci2(n - 1) + fibonacci2(n - 2);
        cache.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(6));

        System.out.println("approach 2:");
        System.out.println(fibonacci2(1));
        System.out.println(fibonacci2(2));
        System.out.println(fibonacci2(3));
        System.out.println(fibonacci2(4));
        System.out.println(fibonacci2(5));
        System.out.println(fibonacci2(6));
    }
}
