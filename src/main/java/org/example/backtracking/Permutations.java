package org.example.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * Example 2:
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 *
 * Example 3:
 * Input: nums = [1]
 * Output: [[1]]
 *
 * Constraints:
 *     1 <= nums.length <= 6
 *     -10 <= nums[i] <= 10
 *     All the integers of nums are unique.
 */

public class Permutations {
    /**
     * Solution 1: backtracking with temp list contains
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if (tempList.size() == nums.length)
            list.add(new ArrayList<>(tempList));
        else {
            for (int num : nums) {
                // contains Time is O(n)
                if (tempList.contains(num)) continue; // element already exists, skip
                tempList.add(num);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    /**
     * Solution 2: backtracking with Collections swap method
     * @param nums
     * @return
     */
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> nums_list = new ArrayList<>();
        for (int x : nums) { // O(n)
            nums_list.add(x);
        }
        backtrack2(list, nums_list, nums.length, 0);
        return list;
    }

    private void backtrack2(List<List<Integer>> list, List<Integer> nums_list, int n, int first){
        if (first == n) list.add(new ArrayList<>(nums_list));
        else {
            for (int i = first; i < n; i++) {
                Collections.swap(nums_list, i, first); //O(1)
                backtrack2(list, nums_list, n, first + 1);
                Collections.swap(nums_list, i, first);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,4,5};
        Permutations solution = new Permutations();

        System.out.println("Solution 1: ");
        List<List<Integer>> result = solution.permute(nums);
        for (List<Integer> list : result) {
            System.out.println(list);
        }

        System.out.println("Solution 2: ");
        List<List<Integer>> result2 = solution.permute2(nums);
        for (List<Integer> list : result2) {
            System.out.println(list);
        }
    }
}

