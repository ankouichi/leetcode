package org.companies.paypal;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 * Constraints:
 *
 *     m == matrix.length
 *     n == matrix[i].length
 *     1 <= m, n <= 10
 *     -100 <= matrix[i][j] <= 100
 *
 */

public class LC54_SpiralMatrix {
    /**
     * Solution 1: initial idea
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        int r = 0, c = 0, dir = 0, count = 1, m = matrix.length, n = matrix[0].length;
        int total = m * n;
        List<Integer> result = new ArrayList<>();
        Map<Integer, Point> accessed = new HashMap<>();
        result.add(matrix[0][0]);
        accessed.put(matrix[0][0], new Point(0,0));
        while (count < total) {
            switch(dir % 4) {
                case 0: // right
                    if (c + 1 < n && accessed.get(matrix[r][c+1]) == null) {
                        result.add(matrix[r][c+1]);
                        accessed.put(matrix[r][c+1], new Point(r, ++c));
                        count++;
                    } else {
                        dir++;
                    }
                    break;
                case 1:
                    if (r + 1 < m && accessed.get(matrix[r+1][c]) == null) {
                        result.add(matrix[r+1][c]);
                        accessed.put(matrix[r+1][c], new Point(++r, c));
                        count++;
                    } else {
                        dir++;
                    }
                    break;
                case 2:
                    if (c - 1 >= 0 && accessed.get(matrix[r][c-1]) == null) {
                        result.add(matrix[r][c-1]);
                        accessed.put(matrix[r][c-1], new Point(r, --c));
                        count++;
                    } else {
                        dir++;
                    }
                    break;
                case 3:
                    if (r - 1 >= 0 && accessed.get(matrix[r-1][c]) == null) {
                        result.add(matrix[r-1][c]);
                        accessed.put(matrix[r-1][c], new Point(--r, c));
                        count++;
                    } else {
                        dir++;
                    }
                    break;
                default:
                    break;
            }
        }

        return result;
    }

    /**
     * Solution 2: Time - O(N), Space - O(N), N is the total number of elements in the input matrix
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0) return ans;
        int R = matrix.length, C = matrix[0].length;
        boolean[][] seen = new boolean[R][C];
        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};
        int r = 0, c = 0, di = 0;
        for (int i = 0; i < R * C; i++) {
            ans.add(matrix[r][c]);
            seen[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];
            if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]) {
                r = cr;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }

        return ans;
    }

    /**
     * Solution 3: Time - O(N), Space - O(N)/O(1): with/without considering output list
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder3(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0) return ans;
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) ans.add(matrix[r1][c]);
            for (int r = r1 + 1; r <= r2; r++) ans.add(matrix[r][c2]);
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c >= c1; c--) ans.add(matrix[r2][c]);
                for (int r = r2 - 1; r > r1; r--) ans.add(matrix[r][c1]);
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = i * 3 + j + 1;
            }
        }

        System.out.println("Solution 1: ");
        for (Integer x : spiralOrder(arr)) {
            System.out.print(x + " ");
        }
        System.out.println();

        System.out.println("Solution 2: ");
        for (Integer x : spiralOrder2(arr)) {
            System.out.print(x + " ");
        }
        System.out.println();

        System.out.println("Solution 3: ");
        for (Integer x : spiralOrder3(arr)) {
            System.out.print(x + " ");
        }
    }
}
