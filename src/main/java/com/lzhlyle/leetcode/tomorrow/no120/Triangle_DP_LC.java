package com.lzhlyle.leetcode.tomorrow.no120;

import java.util.List;

public class Triangle_DP_LC {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] dp = new int[len + 1]; // len + 1
        for (int r = len - 1; r >= 0; r--) {
            List<Integer> row = triangle.get(r);
            for (int c = 0; c < row.size(); c++) {
                dp[c] = Math.min(dp[c], dp[c + 1]) + row.get(c);
            }
        }
        return dp[0];
    }
}
