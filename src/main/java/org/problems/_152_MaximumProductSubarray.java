package org.problems;

/**
 * Created by ankouichi on 3/18/21
 *
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
 *
 * It is guaranteed that the answer will fit in a 32-bit integer.
 *
 * A subarray is a contiguous subsequence of the array.
 *
 * Example 1:
 *
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 *
 * Example 2:
 *
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 * Constraints:
 *
 *     1 <= nums.length <= 2 * 104
 *     -10 <= nums[i] <= 10
 *
 */

public class _152_MaximumProductSubarray {
    public static void main(String[] args) {
        int[] arr1 = new int[] {2, 3, -2, 4};
        System.out.println("Approach 1");
        System.out.println(maxProductSubArray(arr1));
        System.out.println("Approach 2");
        System.out.println(maxProductSubArray2(arr1));
    }

    /**
     * Approach 1 : Brute Force
     * Time: O(n^2)    Space: O(1)
     * @param arr
     * @return
     */
    public static int maxProductSubArray(int[] arr) {
        int result = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int accu = 1;
            for (int j = i; j < arr.length; j++) {
                accu *= arr[j];
                result = Math.max(result, accu);
            }
        }

        return result;
    }

    /**
     * Approach 2
     * Time: O(n)   Space: O(1)
     * @param arr
     * @return
     */
    public static int maxProductSubArray2(int[] arr) {
        int localMax = arr[0], localMin = arr[0], result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int x = arr[i];
            int tmpMax = Math.max(x, Math.max(localMin * x, localMax * x));
            localMin = Math.min(x, Math.min(localMin * x, localMax * x));
            localMax = tmpMax;
            result = Math.max(result, localMax);
        }

        return result;
    }
}
