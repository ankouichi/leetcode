package org.example.traversal;

/**
 * Created by ankouichi on 1/29/21
 */

public class IslandNumberUsingDFS {
    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || r >= nr || c < 0 || c >= nc || grid[r][c] == '0')
            return;

        grid[r][c] = '0';
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
        dfs(grid, r, c-1);
        dfs(grid, r, c+1);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int nr = grid.length;
        int nc = grid[0].length;
        int num = 0;

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    ++num;
                    dfs(grid, i, j);
                }
            }
        }

        return num;
    }

    public static void main(String[] args) {
        char[][] map = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','1','1','1','0'},
                {'0','0','0','1','1'}
        };

        IslandNumberUsingDFS dfs = new IslandNumberUsingDFS();
        System.out.println(dfs.numIslands(map));
    }
}
