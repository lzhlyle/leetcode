package com.lzhlyle.leetcode.recite.no44;

public class WildcardMatching_LC_DP {
    public boolean isMatch(String s, String p) {
        int slen = s.length(), plen = p.length();
        boolean[][] dp = new boolean[slen + 1][plen + 1];
        dp[0][0] = true;
        for (int pi = 1; pi <= plen; pi++) {
            dp[0][pi] = dp[0][pi - 1] && p.charAt(pi - 1) == '*';
        }

        for (int si = 0; si < slen; si++) {
            for (int pi = 0; pi < plen; pi++) {
                if (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?') {
                    dp[si + 1][pi + 1] = dp[si][pi];
                }
                if (p.charAt(pi) == '*') {
                    dp[si + 1][pi + 1] = dp[si + 1][pi] || dp[si][pi + 1];
                }
            }
        }
        return dp[slen][plen];
    }
}
