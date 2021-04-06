package org.companies.paypal;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements
 * of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 * Constraints:
 * 2 <= nums.length <= 10^5
 * -30 <= nums[i] <= 30
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 *
 * Follow up:
 *
 * Could you solve it in O(n) time complexity and without using division?
 * Could you solve it with O(1) constant space complexity? (The output array does not count as extra space for
 * space complexity analysis.)
 */
public class LC238_ProductOfArrayExceptSelf {
    /**
     * Solution 1: Time - O(N), Space - O(N)
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] ans = new int[N], left = new int[N], right = new int[N];
        left[0] = 1;
        right[N - 1] = 1;
        for (int i = 1; i < N; i++) {
            left[i] = nums[i - 1] * left[i - 1];
            right[N - i - 1] = right[N - i] * nums[N - i];
        }
        for (int i = 0; i < N; i++) {
            ans[i] = left[i] * right[i];
        }

        return ans;
    }

    /**
     * Solution 2: Time - O(n), Space - O(1)
     * @param nums
     * @return
     */
    public static int[] productExceptSelf2(int[] nums) {
        int N = nums.length;
        int[] ans = new int[N];
        ans[0] = 1;
        for (int i = 1; i < N; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int temp = 1;
        for (int i = N - 1; i >= 0; i--) {
            ans[i] *= temp;
            temp *= nums[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println("solution 1: ");
        for (int x : productExceptSelf(nums))
            System.out.print(x + " ");

        System.out.println("\nsolution 2: ");
        for (int x : productExceptSelf2(nums))
            System.out.print(x + " ");

        System.out.println("\nsolution 1: ");
        nums = new int[] {-1,1,0,-3,3};
        for (int x : productExceptSelf(nums))
            System.out.print(x + " ");

        System.out.println("\nsolution 2:");
        for (int x : productExceptSelf2(nums))
            System.out.print(x + " ");
    }
}
