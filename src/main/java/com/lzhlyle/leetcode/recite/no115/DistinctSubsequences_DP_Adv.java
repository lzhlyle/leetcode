package com.lzhlyle.leetcode.recite.no115;

public class DistinctSubsequences_DP_Adv {
    public int numDistinct(String s, String t) {
        int slen = s.length(), tlen = t.length();
        int[] dp = new int[tlen + 1];
        for (int si = 1; si <= slen; si++) {
            int northwest = 1; // dp[0]
            for (int ti = 1; ti <= tlen; ti++) {
                int nextNorthwest = dp[ti];
                if (s.charAt(si - 1) == t.charAt(ti - 1)) dp[ti] += northwest;
                northwest = nextNorthwest;
            }
        }
        return dp[tlen];
    }
}
