package com.lzhlyle.leetcode.tomorrow.no115;

public class DistinctSubsequences_DP_Adv {
    public int numDistinct(String s, String t) {
        int slen = s.length(), tlen = t.length();
        int[] dp = new int[tlen + 1];
        for (int si = 0; si < slen; si++) {
            int northwest = dp[0] = 1;
            for (int ti = 0; ti < tlen; ti++) {
                int next = dp[ti + 1];
                if (s.charAt(si) == t.charAt(ti)) dp[ti + 1] += northwest;
                northwest = next;
            }
        }
        return dp[tlen];
    }
}
