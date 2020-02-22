package com.lzhlyle.leetcode.recite.no115;

public class DistinctSubsequences_DP {
    public int numDistinct(String s, String t) {
        int slen = s.length(), tlen = t.length();
        int[][] dp = new int[slen + 1][tlen + 1];
        for (int si = 0; si <= slen; si++) dp[si][0] = 1;
        for (int si = 1; si <= slen; si++) {
            for (int ti = 1; ti <= tlen; ti++) {
                dp[si][ti] = dp[si - 1][ti];
                if (s.charAt(si - 1) == t.charAt(ti - 1)) dp[si][ti] += dp[si - 1][ti - 1];
            }
        }
        return dp[slen][tlen];
    }
}
