package com.lzhlyle.leetcode.recite.no647;

public class PalindromicSubstrings_LC_DP {
    public int countSubstrings(String s) {
        int len = s.length(), cnt = 0;
        char[] arr = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        // 因为 dp[l][r] 依赖于 dp[l+1][r-1]，故 r 从小到大，l 从大到小
        for (int l = len; l > -1; l--) {
            for (int r = l; r < len; r++) {
                dp[l][r] = arr[l] == arr[r] && (r - l < 2 || dp[l + 1][r - 1]);
                if (dp[l][r]) cnt++;
            }
        }
        return cnt;
    }
}
