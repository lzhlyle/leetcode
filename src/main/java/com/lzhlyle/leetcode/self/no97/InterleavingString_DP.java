package com.lzhlyle.leetcode.self.no97;

public class InterleavingString_DP {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        char[] arr1 = s1.toCharArray(), arr2 = s2.toCharArray(), arr3 = s3.toCharArray();
        int m = arr1.length, n = arr2.length;
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;
        for (int i = 1; i <= m; i++)
            if (!(dp[i][0] = arr1[i - 1] == arr3[i - 1])) break;
        for (int j = 1; j <= n; j++)
            if (!(dp[0][j] = arr2[j - 1] == arr3[j - 1])) break;

        for (int i = 1; i <= m; i++) {
            boolean any = dp[i][0];
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (arr1[i - 1] == arr3[i + j - 1] && dp[i - 1][j]) ||
                        (arr2[j - 1] == arr3[i + j - 1] && dp[i][j - 1]);
                if (!any && dp[i][j]) any = true;
            }
            if (!any) return false;
        }
        return dp[m][n];
    }
}
