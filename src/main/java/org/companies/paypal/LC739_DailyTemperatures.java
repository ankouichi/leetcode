package org.companies.paypal;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given a list of daily temperatures T, return a list such that, for each day in the input,
 * tells you how many days you would have to wait until a warmer temperature.
 * If there is no future day for which this is possible, put 0 instead.
 *
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73],
 * your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 *
 * Note: The length of temperatures will be in the range [1, 30000].
 * Each temperature will be an integer in the range [30, 100].
 */

public class LC739_DailyTemperatures {
    /**
     * Time - O(n * w) where w is the number of allowed values for T[i], Space - O(1)
     * @param T
     * @return
     */
    public static int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);
        for (int i = T.length - 1; i >= 0; --i) {
            int warmer_index = Integer.MAX_VALUE;
            for (int t = T[i] + 1; t <= 100; ++t) {
                if (next[t] < warmer_index)
                    warmer_index = next[t];
            }
            if (warmer_index < Integer.MAX_VALUE)
                ans[i] = warmer_index - i;
            next[T[i]] = i;
        }

        return ans;
    }

    /**
     * Time - O(), Space - O()
     * @param T
     * @return
     */
    public static int[] dailyTemperatures2(int[] T) {
        int[] ret = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
            stack.push(i);
        }

        return ret;
    }

    /**
     * Solution 3, array replace stack, beat 99% submission
     * @param T
     * @return
     */
    public static int[] dailyTemperatures3(int[] T) {
        int[] ret = new int[T.length];
        int[] stack = new int[T.length];
        int top = -1;
        for (int i = 0; i < T.length; i++) {
            while (top > -1 && T[i] > T[stack[top]]) {
                int idx = stack[top--];
                ret[idx] = i - idx;
            }
            stack[++top] = i;
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] t = {60,61,62,63,64};
        System.out.println("solution 1: ");
        for (int x : dailyTemperatures(t)) {
            System.out.print(x + " ");
        }

        System.out.println();
        System.out.println("solution 2:");
        for (int x : dailyTemperatures2(t)) {
            System.out.print(x + " ");
        }

        System.out.println();
        System.out.println("solution 3:");
        for (int x : dailyTemperatures3(t)) {
            System.out.print(x + " ");
        }
    }
}
