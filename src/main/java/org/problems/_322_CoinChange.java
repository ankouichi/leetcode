package org.problems;

/**
 * Created by ankouichi on 3/11/21
 *
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 * Example 1:
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 *
 * Example 3:
 *
 * Input: coins = [1], amount = 0
 * Output: 0
 *
 * Example 4:
 *
 * Input: coins = [1], amount = 1
 * Output: 1
 *
 * Example 5:
 *
 * Input: coins = [1], amount = 2
 * Output: 2
 *
 * Constraints:
 *
 *     1 <= coins.length <= 12
 *     1 <= coins[i] <= 231 - 1
 *     0 <= amount <= 104
 *
 */

public class _322_CoinChange {
    public static void main(String[] args) {
        int[] coins = new int[] {1,2,5};
        int amount = 11;
//        System.out.println(coinChange(coins, amount));
//        coins = new int[] {2};
//        amount = 3;
//        System.out.println(coinChange(coins, amount));
//        coins = new int[] {1};
//        amount = 0;
//        System.out.println(coinChange(coins, amount));
//        coins = new int[] {1};
//        amount = 1;
//        System.out.println(coinChange(coins, amount));
        System.out.println(coinChange2(coins, amount));
    }

    /**
     * Approach 1: Brute Force with backtracking
     * @param coins
     * @param amount
     * @return
     * Time: O(S^n), Space: O(n)
     * where S is the amount
     * n is the number of items in coins array
     */
    public static int coinChange(int[] coins, int amount) {
        return coinChange(0, coins, amount);
    }

    private static int coinChange(int idxCoin, int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (amount > 0 && idxCoin < coins.length) {
            int maxVal = amount / coins[idxCoin];
            int minCost = Integer.MAX_VALUE;
            for (int i = 0; i <= maxVal; i++) {
                if (amount >= i * coins[idxCoin]) {
                    int res = coinChange(idxCoin + 1, coins, amount - i * coins[idxCoin]);
                    if (res != -1)
                        minCost = Math.min(minCost, res + i);
                }
            }

            return minCost == Integer.MAX_VALUE ? -1 : minCost;
        }

        return -1;
    }

    /**
     * Approach 2: DP with backtracking
     * @param coins
     * @param amount
     * @return
     * Time - O(S*n), Space - O(s)
     */
    public static int coinChange2(int[] coins, int amount) {
        return coinChange2(coins, amount, new int[amount]);
    }

    private static int coinChange2(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange2(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }
}
