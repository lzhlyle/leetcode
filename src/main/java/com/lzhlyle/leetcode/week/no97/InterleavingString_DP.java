package com.lzhlyle.leetcode.week.no97;

public class InterleavingString_DP {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] marr = s1.toCharArray(), narr = s2.toCharArray(), arr = s3.toCharArray();
        int m = marr.length, n = narr.length, len = arr.length;
        if (m + n != len) return false;

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m && dp[i - 1][0]; i++)
            dp[i][0] = marr[i - 1] == arr[i - 1];
        for (int j = 1; j <= n && dp[0][j - 1]; j++)
            dp[0][j] = narr[j - 1] == arr[j - 1];

        for (int i = 1; i <= m; i++) {
            boolean any = dp[i][0]; // default
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] && marr[i - 1] == arr[i + j - 1]) ||
                        (dp[i][j - 1] && narr[j - 1] == arr[i + j - 1]);
                if (!any) any = dp[i][j];
            }
            if (!any) return false;
        }
        return dp[m][n];
    }
}
