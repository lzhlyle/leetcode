package com.lzhlyle.leetcode.tomorrow.no647;

public class PalindromicSubstrings_LC_DP {
    public int countSubstrings(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length, cnt = 0;
        boolean[][] dp = new boolean[len][len];
        for (int r = 0; r < len; r++) {
            for (int l = r; l >= 0; l--) {
                dp[l][r] = arr[l] == arr[r] && (r - l + 1 < 4 || dp[l + 1][r - 1]);
                if (dp[l][r]) cnt++;
            }
        }
        return cnt;
    }
}
