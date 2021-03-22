package org.companies.wepay;

/**
 * Created by ankouichi on 3/21/21
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -105 <= nums[i] <= 105
 *
 */

public class _LC53_MinimumSubarray {
    public static void main(String[] args) {
        int[] arr1 = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Approach 1: " + maxSubArray(arr1));
        System.out.println("Approach 2: " + maxSubArray2(arr1));
    }

    /**
     * Approach 1: Greedy, locally optimal move at each step will lead to globally optimal solution
     * To find maximum/minimum element or sum in a single array is a good candidate to be solved by the Greedy Algo.
     * Time - O(n), Space - O(1)
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int ans = nums[0], localMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            localMax = Math.max(nums[i], localMax + nums[i]);
            ans = Math.max(ans, localMax);
        }

        return ans;
    }

    /**
     * Approach 2: DP
     * Time - O(n), Space - O(1)
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) nums[i] += nums[i - 1];
            ans = Math.max(ans, nums[i]);
        }

        return ans;
    }
}
