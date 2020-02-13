package com.lzhlyle.leetcode.self.no120;

import java.util.List;

public class Triangle_DP {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        List<Integer> lastRow = triangle.get(rows - 1);
        int[][] dp = new int[rows][lastRow.size()];
        for (int i = 0; i < lastRow.size(); i++) {
            dp[rows - 1][i] = lastRow.get(i);
        }
        for (int i = rows - 2; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + row.get(j);
            }
        }
        return dp[0][0];
    }
}
