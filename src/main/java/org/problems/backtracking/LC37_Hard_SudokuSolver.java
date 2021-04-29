package org.problems.backtracking;

/**
 * @author: Daniel
 * @date: 2021/4/11 21:26
 * @description:
 */
public class LC37_Hard_SudokuSolver {
    // box size
    int n = 3;
    // row size
    int N = n * n;

    int[][] rows = new int[N][N + 1];
    int[][] columns = new int[N][N + 1];
    int[][] boxes = new int[N][N + 1];

    char[][] board;
    boolean sudokuSolved = false;

    // Entry
    public void solveSudoku(char[][] board) {
        this.board = board;
        // init rows, columns and boxes
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int d = Character.getNumericValue(c);
                    placeNumber(d, i, j);
                }
            }
        }

        backtrack(0, 0);
    }

    private void backtrack(int row, int col) {
        if (this.board[row][col] == '.') {
            for (int d = 1; d < 10; d++) {
                if (couldPlace(d, row, col)) {
                    placeNumber(d, row, col);
                    placeNextNumber(row, col);
                    if (!sudokuSolved) removeNumber(d, row, col);
                }
            }
        } else placeNextNumber(row, col);
    }

    private boolean couldPlace(int d, int r, int c) {
        int idx = (r / n) * n + c / n;
        return this.rows[r][d] + this.columns[c][d] + this.boxes[idx][d] == 0;
    }

    private void placeNumber(int d, int r,int c) {
        int boxIdx = n * (r / n) + c / n;
        this.rows[r][d]++;
        this.columns[c][d]++;
        this.boxes[boxIdx][d]++;
        // convert int to char
        this.board[r][c] = (char) (d + '0');
    }

    private void placeNextNumber(int r, int c) {
        if ((c == N - 1) && (r == N - 1)) {
            sudokuSolved = true;
        } else {
            if (c == N - 1) backtrack(r + 1, 0);
            else backtrack(r, c + 1);
        }
    }

    private void removeNumber(int d, int r, int c) {
        int idx = (r / n) * n + c / n;
        this.rows[r][d]--;
        this.columns[c][d]--;
        this.boxes[idx][d]--;
        this.board[r][c] = '.';
    }

    public static void main(String[] args) {
        char[][] arr = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        LC37_Hard_SudokuSolver solution = new LC37_Hard_SudokuSolver();
        solution.solveSudoku(arr);
        for (char[] line : arr) {
            for (char c : line)
                System.out.print(c + " ");
            System.out.println();
        }
    }
}
