package org.companies.wepay;

/**
 * Created by ankouichi on 3/21/21
 *
 * Constraints:
 *
 * 0 <= n <= 30
 */

public class _LC509_Fibonacci {
    /**
     * Approach 1: general recursive solution
     * Time: roughly O(2^n)
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * Approach 2: Top-down dynamic programming (Memoization)
     * Time: O(n), Space: O(n)
     * @param n
     * @return
     */
    public int fib2(int n) {
        return fib(n, new int[n + 1]);
    }

    private int fib(int i, int[] memo) {
        if (i == 0 || i == 1) return i;
        if (memo[i] == 0)
            memo[i] = fib(i - 1, memo) + fib(i - 2, memo);
        return memo[i];
    }

    /**
     * Approach 3: Bottom-up DP
     * Time: O(n), Space: O(n)
     * @param n
     * @return
     */
    public int fib3(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] memo = new int[n];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i < n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n - 1] + memo[n - 2];
    }

    public static void main(String[] args) {
        _LC509_Fibonacci solution = new _LC509_Fibonacci();
        System.out.println("Approach 1 of 3: " + solution.fib(3));
        System.out.println("Approach 2 of 5: " + solution.fib2(5));
        System.out.println("Approach 2 of 6: " + solution.fib2(6));
        System.out.println("Approach 3 of 6: " + solution.fib3(6));
    }
}
