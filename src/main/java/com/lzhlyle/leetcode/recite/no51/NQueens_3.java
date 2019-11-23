package com.lzhlyle.leetcode.recite.no51;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NQueens_3 {
    public List<List<String>> solveNQueens(int n) {
        // base condition
        if (n <= 0) return Collections.emptyList();
        if (n == 1) return Collections.singletonList(Collections.singletonList("Q"));

        int[] queensCol = new int[n]; // 摆放位置：第index行，第value列 -- 初始时，n个皇后都挤在(0, 0)
        int[] visitedCol = new int[n]; // 访问过的列, faster than Set<Integer>
        int[] visitedUphill = new int[2 * n - 1]; // 上山 斜对角线占用情况，2n-1 条, faster than boolean[]
        int[] visitedDownhill = new int[2 * n - 1]; // 下山 斜对角线占用情况，2n-1 条, faster than boolean[]

        List<List<String>> result = new ArrayList<>();
        this.locate(0, n, result, queensCol, visitedCol, visitedUphill, visitedDownhill);
        return result;
    }

    // dfs
    private void locate(int row, int n, List<List<String>> result,
                        int[] queensCol, int[] visitedCol, int[] visitedUphill, int[] visitedDownhill) {
        // terminator
        // which col
        for (int col = 0; col < n; col++) {
            // current position: (row, col)
            // process
            if (validate(row, col, n, visitedCol, visitedUphill, visitedDownhill)) {
                // locate
                queensCol[row] = col;
                // visited
                visitedCol[col] = 1;
                visitedUphill[row + col] = 1;
                visitedDownhill[n - 1 + row - col] = 1; // why +(n-1): [-(n-1), n-1] -> [0, 2n-2]

                if (row == n - 1) appendCurrBoard(result, queensCol);
                    // drill down
                else this.locate(row + 1, n, result, queensCol, visitedCol, visitedUphill, visitedDownhill);

                // reverse state
                queensCol[row] = 0;
                visitedCol[col] = 0;
                visitedUphill[row + col] = 0;
                visitedDownhill[n - 1 + row - col] = 0;
            }
        }
    }

    private boolean validate(int x, int y, int n, int[] visitedCol, int[] visitedUphill, int[] visitedDownhill) {
        // 行无需关系，已在dfs中避免row重复
        // 列、上山、下山
        return visitedCol[y] + visitedUphill[x + y] + visitedDownhill[n - 1 + x - y] == 0;
    }

    private void appendCurrBoard(List<List<String>> result, int[] cols) {
        List<String> currBoard = new ArrayList<>();
        for (int col : cols) {
            StringBuilder builder = new StringBuilder();
            for (int y = 0; y < cols.length; y++) {
                if (col == y) builder.append('Q');
                else builder.append('.');
            }
            currBoard.add(builder.toString());
        }
        result.add(currBoard);
    }

    public static void main(String[] args) {
        Object res = new NQueens_3().solveNQueens(4);
        System.out.println(res);
    }
}
