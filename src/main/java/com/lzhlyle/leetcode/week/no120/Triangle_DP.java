package com.lzhlyle.leetcode.week.no120;

import java.util.List;

public class Triangle_DP {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] dp = new int[len][len];
        for (int c = 0; c < len; c++) dp[len - 1][c] = triangle.get(len - 1).get(c);
        for (int r = len - 2; r >= 0; r--) {
            List<Integer> row = triangle.get(r);
            for (int c = 0; c < row.size(); c++) {
                dp[r][c] = Math.min(dp[r + 1][c], dp[r + 1][c + 1]) + row.get(c);
            }
        }
        return dp[0][0];
    }
}
