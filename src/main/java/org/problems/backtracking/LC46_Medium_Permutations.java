package org.problems.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Daniel
 * @date: 2021/4/19 0:22
 * @description:
 */
public class LC46_Medium_Permutations {
//    private List<List<Integer>> result = new LinkedList<>();
//    private int n;
//
//    public List<List<Integer>> permute(int[] nums) {
//        this.n = nums.length;
//        ArrayList<Integer> nums_list = new ArrayList<>();
//        for (int n : nums) {
//            nums_list.add(n);
//        }
//
//        backtrack(0, nums_list);
//        return result;
//    }
//
//    private void backtrack(int first, ArrayList<Integer> curr) {
//        if (first == n)
//            result.add(new ArrayList<>(curr));
//        for (int i = first; i < n; i++) {
//            Collections.swap(curr, i, first);
//            backtrack(i + 1, curr);
//            Collections.swap(curr, i, first);
//        }
//    }

    public void backtrack(int n,
                          ArrayList<Integer> nums,
                          List<List<Integer>> output,
                          int first) {
        // if all integers are used up
        if (first == n)
            output.add(new ArrayList<Integer>(nums));
        for (int i = first; i < n; i++) {
            // place i-th integer first
            // in the current permutation
            Collections.swap(nums, first, i);
            // use next integers to complete the permutations
            backtrack(n, nums, output, first + 1);
            // backtrack
            Collections.swap(nums, first, i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        // init output list
        List<List<Integer>> output = new LinkedList();

        // convert nums into list since the output is a list of lists
        ArrayList<Integer> nums_lst = new ArrayList<Integer>();
        for (int num : nums)
            nums_lst.add(num);

        int n = nums.length;
        backtrack(n, nums_lst, output, 0);
        return output;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        LC46_Medium_Permutations solution = new LC46_Medium_Permutations();
        List<List<Integer>> ans = solution.permute(arr);
        System.out.println("total count: " + ans.size());
        for (List<Integer> list : ans) {
            for (int i : list)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
