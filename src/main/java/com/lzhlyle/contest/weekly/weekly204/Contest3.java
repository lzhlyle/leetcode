package com.lzhlyle.contest.weekly.weekly204;

public class Contest3 {
    // 0/1/2
    // 0: 是否已经有两个以上的岛屿
    // 1: 逐个尝试消除
    // 2: 最多为 2
    public int minDays(int[][] grid) {
        int cnt = cnt(grid); // O(mn)
        if (cnt == 0 || cnt > 1) return 0;

        // 恢复 grid
        int one = 0;
        // O(mn)
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == -1) grid[i][j] = 1;
                one++;
            }
        }
        if (one == 2) return 2;

        // 逐个尝试消除
        // O(mn * mn)
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (cnt(grid) > 1) return 1;
                    recover(grid);
                    grid[i][j] = 1;
                }
            }
        }

        return 2;
    }

    private void recover(int[][] grid) {
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == -1) grid[i][j] = 1;
    }

    private int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

    // dfs + flood-fill
    private int cnt(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void dfs(int[][] grid, int i, int j) {
        grid[i][j] = -1; // flood-fill
        for (int di = 0; di < 4; di++) {
            int x = i + dx[di], y = j + dy[di];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                dfs(grid, x, y);
            }
        }
    }

    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {

        }
    }
}
