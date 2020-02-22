package com.lzhlyle.leetcode.week.no120;

import java.util.List;

public class Triangle_DP_LC {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] dp = new int[len];
        for (int c = 0; c < len; c++) dp[c] = triangle.get(len - 1).get(c);
        for (int r = len - 2; r >= 0; r--) {
            List<Integer> row = triangle.get(r);
            for (int c = 0; c < row.size(); c++) {
                dp[c] = Math.min(dp[c], dp[c + 1]) + row.get(c);
            }
        }
        return dp[0];
    }
}
