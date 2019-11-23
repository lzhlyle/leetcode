package com.lzhlyle.leetcode.recite.no51;

import java.util.*;

public class NQueens_2 {
    public List<List<String>> solveNQueens(int n) {
        // base condition
        if (n <= 0) return Collections.emptyList();
        if (n == 1) return Collections.singletonList(Collections.singletonList("Q"));

        int[] queensCol = new int[n]; // 摆放位置：第index行，第value列 -- 初始时，n个皇后都挤在(0, 0)
        Set<Integer> visitedCol = new HashSet<>(); // 访问过的列，优化遍历 queensCol 的 O(n) 为 O(1)
        boolean[] visitedUphill = new boolean[2 * n - 1]; // 上山 斜对角线占用情况，2n-1 条
        boolean[] visitedDownhill = new boolean[2 * n - 1]; // 下山 斜对角线占用情况，2n-1 条

        List<List<String>> result = new ArrayList<>();
        this.locate(0, n, result, queensCol, visitedCol, visitedUphill, visitedDownhill);
        return result;
    }

    // dfs
    private void locate(int row, int n, List<List<String>> result,
                        int[] queensCol, Set<Integer> visitedCol, boolean[] visitedUphill, boolean[] visitedDownhill) {
        // terminator
        // which col
        for (int col = 0; col < n; col++) {
            // current position: (row, col)
            // process
            if (validate(row, col, n, visitedCol, visitedUphill, visitedDownhill)) {
                // locate
                queensCol[row] = col;
                // visited
                visitedCol.add(col);
                visitedUphill[row + col] = true;
                visitedDownhill[n - 1 + row - col] = true;

                if (row == n - 1) appendCurrBoard(result, queensCol);
                    // drill down
                else this.locate(row + 1, n, result, queensCol, visitedCol, visitedUphill, visitedDownhill);

                // reverse state
                queensCol[row] = 0;
                visitedCol.remove(col);
                visitedUphill[row + col] = false;
                visitedDownhill[n - 1 + row - col] = false;
            }
        }
    }

    private boolean validate(int x, int y, int n, Set<Integer> visitedCol, boolean[] visitedUphill, boolean[] visitedDownhill) {
        // 行无需关系，已在dfs中避免row重复
        // 列、上山、下山
        return !visitedCol.contains(y) && !visitedUphill[x + y] && !visitedDownhill[n - 1 + x - y];
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
        Object res = new NQueens_2().solveNQueens(4);
        System.out.println(res);
    }
}
