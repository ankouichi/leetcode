package org.problems;

/**
 * Created by ankouichi on 3/10/21
 *
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
 *
 * Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, assume that your function returns 231 − 1 when the division result overflows.
 *
 *
 *
 * Example 1:
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = truncate(3.33333..) = 3.
 * Example 2:
 *
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = truncate(-2.33333..) = -2.
 * Example 3:
 *
 * Input: dividend = 0, divisor = 1
 * Output: 0
 * Example 4:
 *
 * Input: dividend = 1, divisor = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * -231 <= dividend, divisor <= 231 - 1
 * divisor != 0
 *
 */

public class _29_DivideTwoIntegers {

    /**
     * Approach 1: Repeated Subtraction
     * @param dividend
     * @param divisor
     * Time: O(n), Space: O(1)
     * @return
     */
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        int negatives = 2;
        if (dividend > 0) {
            negatives--;
            dividend = -dividend;
        }

        if (divisor > 0) {
            negatives--;
            divisor = -divisor;
        }

        int quotient = 0;
        while (dividend - divisor <= 0) {
            quotient--;
            dividend -= divisor;
        }

        if (negatives != 1) {
            quotient = -quotient;
        }

        return quotient;
    }

    /**
     * Approach 2: Repeated Exponential Searches
     * @param dividend
     * @param divisor
     * Time: O(log2n), Space: O(1)
     * @return
     */
    public static int divide2(int dividend, int divisor) {
        // special case: overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        int negatives = 2;
        if (dividend > 0) {
            dividend = -dividend;
            negatives--;
        }
        if (divisor > 0) {
            divisor = -divisor;
            negatives--;
        }

        int quotient = 0;
        while (divisor >= dividend) {
            int powerOfTwo = -1;
            int value = divisor;
            // -1073741824 is half of Integer.MIN_VALUE
            while (value >= -1073741824 && value + value >= dividend) {
                value += value;
                powerOfTwo += powerOfTwo;
            }

            quotient += powerOfTwo;
            dividend -= value;
        }

        if (negatives != 1) {
            quotient = -quotient;
        }

        return quotient;
    }

    public static void main(String[] args) {
        int a = 100, b = 5;
//        System.out.println(divide(a, b));
//        System.out.println(divide(-a, b));
//        System.out.println(divide(a, -b));
//        System.out.println(divide(-a, -b));

        System.out.println(divide2(a, b));
        System.out.println(divide2(-a, b));
        System.out.println(divide2(a, -b));
        System.out.println(divide2(-a, -b));
    }
}
