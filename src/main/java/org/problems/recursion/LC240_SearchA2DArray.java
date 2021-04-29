package org.problems.recursion;

/**
 * @author: Daniel
 * @date: 2021/4/14 22:23
 * @description:
 */
public class LC240_SearchA2DArray {
    /**
     * Approach 1:
     * Time - O(), Space - O()
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        mat = matrix;
        tar = target;
        if (matrix == null || matrix.length == 0) return false;
        return searchRec(0, 0, matrix[0].length - 1, matrix.length - 1);
    }

    private int[][] mat;
    private int tar;
    private boolean searchRec(int left, int up, int right, int down) {
        if (left > right || up > down) return false;
        if (tar < mat[up][left] || tar > mat[down][right]) return false;
        int mid = left + (right - left) / 2;
        int row = up;
        while (row <= down && mat[row][mid] <= tar) {
            if (mat[row][mid] == tar) return true;
            row++;
        }
        return searchRec(left, row, mid - 1, down) || searchRec(mid + 1, up, right, row - 1);
    }

    /**
     * Approach 2:
     * Time - O(M + N), Space - O(1), where M is the number of rows and N is the number of columns
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int row = matrix.length - 1, col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] > target) {
                row--;
            } else {
                col++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,4,5}, {3,6,8}};
        int target = 5;
        LC240_SearchA2DArray solution = new LC240_SearchA2DArray();
        System.out.println(solution.searchMatrix(matrix, target));
        System.out.println(solution.searchMatrix2(matrix, target));
    }
}
