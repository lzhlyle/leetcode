package com.lzhlyle.leetcode.recite.no200;

public class NumberOfIslands {
    // dfs
    public int numIslands(char[][] grid) {
        // base condition
        if (grid.length <= 0 || grid[0].length <= 0) return 0;

        // dfs, flood fill
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == '1') {
                    count++;
                    this._sinkDown(row, column, grid);
                }
            }
        }
        return count;
    }

    private void _sinkDown(int row, int column, char[][] grid) {
        // terminator
        if (grid[row][column] == '0') return;

        // process
        grid[row][column] = '0'; // sink down

        // drill down
        if (column + 1 < grid[row].length) this._sinkDown(row, column + 1, grid); // east
        if (column - 1 >= 0) this._sinkDown(row, column - 1, grid); // west
        if (row + 1 < grid.length) this._sinkDown(row + 1, column, grid); // south
        if (row - 1 >= 0) this._sinkDown(row - 1, column, grid); // north

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
