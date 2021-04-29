package org.problems.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: Daniel
 * @date: 2021/4/19 0:09
 * @description:
 */
public class LC77_Medium_Combinations {
    private final List<List<Integer>> result = new LinkedList<>();
    private int k;
    private int n;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<>());
        return result;
    }

    private void backtrack(int first, LinkedList<Integer> curr) {
        if (curr.size() == k)
            result.add(new LinkedList<>(curr));
        for (int i = first; i <= n; i++) {
            curr.add(i);
            backtrack(i + 1, curr);
            curr.removeLast();
        }
    }

    public static void main(String[] args) {
        LC77_Medium_Combinations solution = new LC77_Medium_Combinations();
        List<List<Integer>> ans = solution.combine(3, 2);
        System.out.println("total count: " + ans.size());
        for (List<Integer> list : ans) {
            for (int i : list)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
