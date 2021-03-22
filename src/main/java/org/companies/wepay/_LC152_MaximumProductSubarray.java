package org.companies.wepay;

/**
 * Created by ankouichi on 3/21/21
 *
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
 *
 * It is guaranteed that the answer will fit in a 32-bit integer.
 *
 * A subarray is a contiguous subsequence of the array.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 *
 */

public class _LC152_MaximumProductSubarray {

    /**
     * Approach: Dynamic Programming: combo chain, zero, negatives,
     * Time - O(N), Space - O(1)
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        int ans = nums[0], max_so_far = nums[0], min_so_far = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmpMax = Math.max(nums[i], Math.max(max_so_far * nums[i], min_so_far * nums[i]));
            min_so_far = Math.min(nums[i], Math.min(max_so_far * nums[i], min_so_far * nums[i]));
            max_so_far = tmpMax;
            ans = Math.max(max_so_far, ans);
        }

        return ans;
    }

    /**
     * Approach 2: Brute Force, nested two loops
     * Time - O(N^2), Space - O(1)
     * @param nums
     * @return
     */
    public static int maxProduct2(int[] nums) {
        int ans = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int accu = 1;
            for (int j = i; j < nums.length; j++) {
                accu *= nums[j];
                ans = Math.max(ans, accu);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2,3,-2,4};
        System.out.println("Approach 1: " + maxProduct(arr));
        System.out.println("Approach 2: " + maxProduct2(arr));
    }
}
