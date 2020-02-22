package com.lzhlyle.leetcode.recite.no10;

public class RegularExpressionMatching_DP_Recite {

    public boolean isMatch(String s, String p) {
        char[] sarr = s.toCharArray(), parr = p.toCharArray();
        int rows = sarr.length, cols = parr.length;
        boolean[][] dp = new boolean[rows + 1][cols + 1]; // +""
        dp[rows][cols] = true;
        for (int r = rows; r >= 0; r--) {
            for (int c = cols - 1; c >= 0; c--) {
                boolean first = (r < rows) && (parr[c] == '.' || parr[c] == sarr[r]);
                if (c + 1 < cols && parr[c + 1] == '*') {
                    dp[r][c] = (dp[r][c + 2]) || (first && dp[r + 1][c]);
                } else dp[r][c] = first && dp[r + 1][c + 1];
            }
        }
        return dp[0][0];
    }
}
