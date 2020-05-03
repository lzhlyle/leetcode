package com.lzhlyle.contest.weekly.weekly181;

public class Contest3 {
    // dfs
    private int m, n;
    private int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1}; // up, left, down, right
    private int[][] dir = {{2, 3, 4}, {1, 4, 6}, {2, 5, 6}, {1, 3, 5}}; // 四个方向可连通的值
    private int[][] able = {{1, 3}, {0, 2}, {1, 2}, {2, 3}, {0, 1}, {0, 3}}; // 当前能往哪个方向走

    public boolean hasValidPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        return dfs(grid, 0, 0);
    }

    private boolean dfs(int[][] grid, int i, int j) {
        if (i == m - 1 && j == n - 1) return true;
        if (grid[i][j] == 0) return false;
        int ori = grid[i][j];
        grid[i][j] = 0;
        for (int di : able[ori - 1]) {
            int x = i + dx[di], y = j + dy[di];
            if (x >= 0 && x < m && y >= 0 && y < n) {
                if (grid[x][y] != dir[di][0] && grid[x][y] != dir[di][1] && grid[x][y] != dir[di][2]) {
                    // 不通
                    continue;
                }
                // 通
                if (dfs(grid, x, y)) return true;
            }
        }
        grid[i][j] = ori;
        return false;
    }


    public static void main(String[] args) {
        Contest3 contest = new Contest3();
        {
            int[][] grid = {{1, 1, 1, 1, 1, 1, 3}};
            boolean res = contest.hasValidPath(grid);
            System.out.println(res);
        }
    }
}
