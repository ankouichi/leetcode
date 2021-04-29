package org.problems.recursion;

/**
 * @author: Daniel
 * @date: 2021/4/13 3:46
 * @description:
 *
 * Implement pow(x, n), which calculates x raised to the power n (i.e., x^n).
 *
 * Constraints:
 *
 * -100.0 < x < 100.0
 * -2^31 <= n <= 2^31-1
 * -10^4 <= x^n <= 10^4
 */

public class LC50_Medium_Pow {
    public static double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        return fastPow(x, n);
    }

    private static double fastPow(double x, int n) {
        if (n == 0) return 1.0;
        double half = fastPow(x, n / 2);
        return n % 2 == 0 ? half * half : x * half * half;
    }

    public static void main(String[] args) {
        double x = 2.1;
        int n = 3;
        System.out.println(myPow(x, n));
    }
}
