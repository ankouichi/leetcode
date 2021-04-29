package org.problems.backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Daniel
 * @date: 2021/4/15 15:29
 * @description:
 */
public class LC52_Hard_QueenPuzzle {
    private int size;

    public int totalNQueens(int n) {
        size = n;
        return backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    /**
     * Approach 1: backtracking with HashSet
     * Optimization: use boolean array instead of hash set to speed up and save memory
     * @param row
     * @param diagonals
     * @param antiDiagonals
     * @param cols
     * @return
     */
    private int backtrack(int row, Set<Integer> diagonals, Set<Integer> antiDiagonals, Set<Integer> cols) {
        if (row == size) return 1;
        int solutions = 0;
        for (int col = 0; col < size; col++) {
            int diag = row - col;
            int anti_diag = row + col;
            if (diagonals.contains(diag) || antiDiagonals.contains(anti_diag) || cols.contains(col))
                continue;

            diagonals.add(diag);
            antiDiagonals.add(anti_diag);
            cols.add(col);
            solutions += backtrack(row + 1, diagonals, antiDiagonals, cols);

            diagonals.remove(diag);
            antiDiagonals.remove(anti_diag);
            cols.remove(col);
        }
        return solutions;
    }

    public static void main(String[] args) {
        LC52_Hard_QueenPuzzle solution = new LC52_Hard_QueenPuzzle();
        System.out.println(solution.totalNQueens(8));
    }
}
