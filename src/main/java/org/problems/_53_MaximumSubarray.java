package org.problems;

/**
 * Created by ankouichi on 2/11/21
 */

public class _53_MaximumSubarray {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        _53_MaximumSubarray app = new _53_MaximumSubarray();
        System.out.println(app.maxSubArray(arr));
    }

    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    // solution1: divide and conquer
    // leftSum - maxSubArray for the left subarray
    // rightSum - maxSubArray for the right subarray
    // crossSum - maximum sum of the subarray containing elements from both left and right subarrays
    // merge the subproblems - return max(left_sum, right_sum, cross_sum)
    public int helper(int[] nums, int left, int right) {
        if (left == right) return nums[left];

        int p = (left + right) / 2;

        int leftSum = helper(nums, left, p);
        int rightSum = helper(nums, p + 1, right);
        int crossSum = crossSum(nums, left, right, p);

        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }

    public int crossSum(int[] nums, int left, int right, int p) {
        if (left == right) return nums[left];

        int leftSubsum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = p; i > left - 1; --i) {
            currSum += nums[i];
            leftSubsum = Math.max(leftSubsum, currSum);
        }

        int rightSubsum = Integer.MIN_VALUE;
        currSum = 0;
        for(int i = p + 1; i < right + 1; ++i) {
            currSum += nums[i];
            rightSubsum = Math.max(rightSubsum, currSum);
        }

        return leftSubsum + rightSubsum;
    }




}
