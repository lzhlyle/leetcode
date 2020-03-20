package com.lzhlyle.leetcode.self.no647;

public class PalindromicSubstrings_LC_DP {
    public int countSubstrings(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length, cnt = 0;
        boolean[][] dp = new boolean[len][len];
        for (int l = len - 1; l >= 0; l--) {
            for (int r = l; r < len; r++) {
                dp[l][r] = arr[l] == arr[r] && (r - l < 2 || dp[l + 1][r - 1]);
                if (dp[l][r]) cnt++;
            }
        }
        return cnt;
    }
}
