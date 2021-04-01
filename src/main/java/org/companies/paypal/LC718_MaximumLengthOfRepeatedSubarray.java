package org.companies.paypal;

/**
 * Created by ankouichi on 3/29/21
 *
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
 *
 * Example 1:
 *
 * Input:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * Output: 3
 * Explanation:
 * The repeated subarray with maximum length is [3, 2, 1].
 *
 *
 * Note:
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 *
 */

public class LC718_MaximumLengthOfRepeatedSubarray {
    /**
     * DP Solution
     * Intuition: dp[i][j] = dp[i+1][j+1] + 1
     * @param A
     * @param B
     * @return
     */
    public static int findLength(int[] A, int[] B) {
        int maxLen = 0;
        int[][] dp = new int[A.length + 1][B.length + 1];
        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = B.length - 1; j >= 0; j--) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                    if (maxLen < dp[i][j]) maxLen = dp[i][j];
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] a = new int[] {1,2,3};
        int[] b = new int[] {1,2,3};
        System.out.println(findLength(a, b));
    }
}
