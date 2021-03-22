package org.problems;

/**
 * Created by ankouichi on 3/17/21
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 10^4
 * -10^5 <= nums[i] <= 10^5
 *
 */

public class _53_MaxSubArray {
    public static int maxSubArray(int[] arr) {
        int ans = Integer.MIN_VALUE;
        int local_max = 0;
        for (int x : arr) {
            local_max = Math.max(local_max + x, x);
            ans = Math.max(ans, local_max);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr1));
    }
}
