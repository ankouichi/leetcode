package org.problems.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Daniel
 * @date: 2021/4/12 18:11
 * @description:
 */
public class LC119_Easy_PascalTriangleII {
    private static class RowCol {
        private final int row, col;
        public RowCol(int r, int c) {
            this.row = r;
            this.col = c;
        }

        @Override
        public int hashCode() {
            int result = (int) (row ^ (row >>> 32));
            return (result << 5) - 1 + (int) (col ^ (col >>> 32)); // 31 * result == (result << 5) - 1
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            if (o == null) return false;
            if (!(o instanceof RowCol)) return false;
            RowCol rc = (RowCol) o;
            return this.row == rc.row && this.col == rc.col;
        }
    }

    private static final Map<RowCol, Integer> cache = new HashMap<>();

    private static int getNum(int row, int col) {
        if (row == 0 || col == 0 || row == col) return 1;

        RowCol rowCol = new RowCol(row, col);
        if (cache.containsKey(rowCol)) {
            return cache.get(rowCol);
        }

        int val = getNum(row - 1, col - 1) + getNum(row - 1, col);
        cache.put(rowCol, val);
        return val;
    }

    /**
     * Approach 1: memoization
     * @param rowIndex
     * @return
     */
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++)
            ans.add(getNum(rowIndex, i));
        return ans;
    }

    /**
     * Approach 2:
     * @param rowIndex
     * @return
     */
    public static List<Integer> getRow2(int rowIndex) {
        List<Integer> curr, prev = new ArrayList<Integer>() {
            {
                add(1);
            }
        };

        for (int i = 1; i <= rowIndex; i++) {
            curr = new ArrayList<Integer>(i + 1) {
                {
                    add(1);
                }
            };

            for (int j = 1; j < i; j++) {
                curr.add(prev.get(j - 1) + prev.get(j));
            }

            curr.add(1);
            prev = curr;
        }

        return prev;
    }

    public static void main(String[] args) {
//        for (int j = 0; j <= 4; j++) {
//            for (int x : getRow(j))
//                System.out.print(x + " ");
//            System.out.println();
//        }

        for (int j = 0; j <= 4; j++) {
            for (int x : getRow2(j))
                System.out.print(x + " ");
            System.out.println();
        }
    }
}
