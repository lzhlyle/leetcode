package com.lzhlyle.leetcode.self.no115;

public class DistinctSubsequences_DP {
    public int numDistinct(String s, String t) {
        int slen = s.length(), tlen = t.length();
        int[][] dp = new int[slen + 1][tlen + 1];
        for (int si = 0; si < slen; si++) dp[si][0] = 1;
        for (int si = 0; si < slen; si++) {
            for (int ti = 0; ti < tlen; ti++) {
                dp[si + 1][ti + 1] = dp[si][ti + 1];
                if (s.charAt(si) == t.charAt(ti)) dp[si + 1][ti + 1] += dp[si][ti];
            }
        }
        return dp[slen][tlen];
    }
}
