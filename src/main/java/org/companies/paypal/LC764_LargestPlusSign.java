package org.companies.paypal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ankouichi on 3/30/21
 *
 * In a 2D grid from (0, 0) to (N-1, N-1), every cell contains a 1,
 * except those cells in the given list mines which are 0.
 * What is the largest axis-aligned plus sign of 1s contained in the grid?
 * Return the order of the plus sign. If there is none, return 0.
 *
 * An "axis-aligned plus sign of 1s of order k" has some center grid[x][y] = 1 along with 4 arms of
 * length k-1 going up, down, left, and right, and made of 1s. This is demonstrated in the diagrams below.
 * Note that there could be 0s or 1s beyond the arms of the plus sign,
 * only the relevant area of the plus sign is checked for 1s.
 */

public class LC764_LargestPlusSign {
    public static int orderOfLargestPlusSign(int N, int[][] mines) {
        Set<Integer> banned = new HashSet<>();
        for (int[] m : mines) {
            banned.add(m[0] * N + m[1]);
        }

        int[][] dp = new int[N][N];
        for (int r = 0; r < N; r++) {
            int count = 0;
            for (int c = 0; c < N; c++) {
                count = banned.contains(r * N + c) ? 0 : count + 1;
                dp[r][c] = count;
            }

            count = 0;
            for (int c = N - 1; c >= 0; c--) {
                count = banned.contains(r * N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }
        }

        int ans = 0;
        for (int c = 0; c < N; c++) {
            int count = 0;
            for (int r = 0; r < N; r++) {
                count = banned.contains(r * N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }

            count = 0;
            for (int r = N - 1; r >= 0; r--) {
                count = banned.contains(r * N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
                ans = Math.max(dp[r][c], ans);
            }
        }

        return ans;
    }

    public static int orderOfLargestPlusSign2(int N, int[][] mines) {
        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(grid[i], N);
        }
        for (int[] m : mines) {
            grid[m[0]][m[1]] = 0;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0, k = N - 1, l = 0, r = 0, u = 0, d = 0; j < N; j++, k--) {
                grid[i][j] = Math.min(grid[i][j], l = (grid[i][j] == 0 ? 0 : l + 1));
                grid[i][k] = Math.min(grid[i][k], r = (grid[i][k] == 0 ? 0 : r + 1));
                grid[j][i] = Math.min(grid[j][i], u = (grid[j][i] == 0 ? 0 : u + 1));
                grid[k][i] = Math.min(grid[k][i], d = (grid[k][i] == 0 ? 0 : d + 1));
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans = Math.max(grid[i][j], ans);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int N = 5;
        int[][] mines = new int[][] {  };
        System.out.println(orderOfLargestPlusSign2(N, mines));
    }
}
