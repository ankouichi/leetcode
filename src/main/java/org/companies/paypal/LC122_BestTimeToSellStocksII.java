package org.companies.paypal;

/**
 *You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Find the maximum profit you can achieve. You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 *
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 *
 *
 * Example 2:
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions
 * at the same time. You must sell before buying again.
 *
 *
 * Example 3:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e., max profit = 0.
 *
 *
 * Constraints:
 *
 * 1 <= prices.length <= 3 * 10^4
 * 0 <= prices[i] <= 10^4
 */
public class LC122_BestTimeToSellStocksII {
    /**
     * Peak Valley Approach: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solution/
     * The key point is we need to consider every peak immediately following a valley to maximize the profit.
     * In case we skip one of the peaks (trying to obtain more profit), we will end up losing the profit over
     * one of the transactions leading to an overall lesser profit.
     *
     *  Time - O(n), Space - O(1)
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int i = 0, max = 0;
        int peak, valley;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) i++;
            peak = prices[i];
            max += peak - valley;
        }
        return max;
    }

    /**
     * Simple One Pass
     * Time - O(n), Space - O(1)
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max += prices[i] > prices[i - 1] ? prices[i] - prices[i - 1] : 0;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("approach one: " + maxProfit(prices));
        System.out.println("approach two: " + maxProfit2(prices));
    }
}
