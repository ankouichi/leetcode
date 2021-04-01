package org.companies.paypal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ankouichi on 3/25/21
 *
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 * Constraints:
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 *
 */

public class LC46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int x : nums) list.add(x);
        List<List<Integer>> ans = new ArrayList<>();
        backtracking(nums.length, 0, ans, list);
        return ans;
    }

    public void backtracking(int n, int first, List<List<Integer>> output, List<Integer> nums) {
        if (first == n)
            output.add(new ArrayList<>(nums));
        else {
            for (int i = first; i < n; i++) {
                Collections.swap(nums, first, i);
                backtracking(n, first + 1, output, nums);
                Collections.swap(nums, first, i);
            }
        }
    }

    public static void main(String[] args) {
        LC46_Permutations solution = new LC46_Permutations();
        int[] arr1 = new int[] {1,2,3};
        List<List<Integer>> res = solution.permute(arr1);
        for (List<Integer> list : res) {
            for (Integer x : list) {
                System.out.print(x);
            }
            System.out.println();
        }
    }
}
