package com.lzhlyle.leetcode.recite.no44;

public class WildcardMatching_LC_DP_BU {
    public boolean isMatch(String s, String p) {
        int slen = s.length(), plen = p.length();
        boolean[][] dp = new boolean[slen + 1][plen + 1];
        dp[slen][plen] = true;
        for (int pi = plen - 1; pi >= 0; pi--) {
            if (p.charAt(pi) == '*') dp[slen][pi] = true;
            else break;
        }

        for (int si = slen - 1; si >= 0; si--) {
            for (int pi = plen - 1; pi >= 0; pi--) {
                if (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?') dp[si][pi] = dp[si + 1][pi + 1];
                else if (p.charAt(pi) == '*') dp[si][pi] = dp[si + 1][pi] || dp[si][pi + 1];
                else dp[si][pi] = false;
            }
        }
        return dp[0][0];
    }
}
