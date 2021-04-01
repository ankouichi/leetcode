package org.companies.paypal;

/**
 * Created by ankouichi on 3/25/21
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * Constraints:
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 *
 */

public class LC121_BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int x : prices) {
            if (x < min)
                min = x;
            else
                max = Math.max(max, x - min);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = new int[] {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
