package com.lzhlyle.leetcode.self.no10;

public class RegularExpressionMatching_DP {
    public boolean isMatch(String s, String p) {
        char[] sarr = s.toCharArray(), parr = p.toCharArray();
        int slen = sarr.length, plen = parr.length;
        boolean[][] dp = new boolean[slen + 1][plen + 1]; // +""
        dp[slen][plen] = true;
        for (int si = slen; si >= 0; si--) {
            for (int pi = plen - 1; pi >= 0; pi--) {
                boolean first = (si < slen) && (parr[pi] == '.' || parr[pi] == sarr[si]);
                if (pi + 1 < plen && parr[pi + 1] == '*') {
                    dp[si][pi] = dp[si][pi + 2] || (first && dp[si + 1][pi]);
                } else dp[si][pi] = first && dp[si + 1][pi + 1];
            }
        }
        return dp[0][0];
    }
}
