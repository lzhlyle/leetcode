package com.lzhlyle.leetcode.self.no200;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        // base condition
        if (grid.length <= 0 || grid[0].length <= 0) return 0;

        int count = 0;

        // traversal
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1') {
                    count++;
                    // dfs
                    this._sinkDown(grid, row, col);
                }
            }
        }

        return count;
    }

    private void _sinkDown(char[][] grid, int row, int col) {
        // terminator
        if (grid[row][col] == '0') return;

        // process
        grid[row][col] = '0';

        // drill down
        if (col + 1 < grid[row].length) this._sinkDown(grid, row, col + 1); // east
        if (col - 1 >= 0) this._sinkDown(grid, row, col - 1); // west
        if (row + 1 < grid.length) this._sinkDown(grid, row + 1, col); // south
        if (row - 1 >= 0) this._sinkDown(grid, row - 1, col); // north

        // reverse state
    }


    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int res = new NumberOfIslands().numIslands(grid);
        System.out.println(res);
    }
}
