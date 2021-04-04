package org.companies.paypal;

/**
 * You may recall that an array arr is a mountain array if and only if:
 *
 * arr.length >= 3
 * There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * Given an integer array arr, return the length of the longest subarray, which is a mountain.
 * Return 0 if there is no mountain subarray.
 *
 * Example 1:
 *
 * Input: arr = [2,1,4,7,3,2,5]
 * Output: 5
 * Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
 * Example 2:
 *
 * Input: arr = [2,2,2]
 * Output: 0
 * Explanation: There is no mountain.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 104
 * 0 <= arr[i] <= 104
 *
 *
 * Follow up:
 *
 * Can you solve it using only one pass?
 * Can you solve it in O(1) space?
 */

public class LC845_LargestMountainInArray {
    /**
     * Time - O(n), Space - O(1), 1 pass
     * @param arr
     * @return
     */
    public static int longestMountain(int[] arr) {
        int N = arr.length;
        int base = 0, ans = 0;
        while (base < N) {
            int end = base;
            if (end + 1 < N && arr[end] < arr[end + 1]) {
                while (end + 1 < N && arr[end] < arr[end + 1]) end++;
                if (end + 1 < N && arr[end] > arr[end + 1]) {
                    while (end + 1 < N && arr[end] > arr[end + 1]) end++;
                    ans = Math.max(ans, end - base + 1);
                }
            }
            base = Math.max(end, base + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1, 0, 2, 3, 1};
        System.out.println(longestMountain(arr));
    }
}
