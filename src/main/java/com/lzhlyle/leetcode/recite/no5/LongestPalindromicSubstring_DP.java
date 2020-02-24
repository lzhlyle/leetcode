package com.lzhlyle.leetcode.recite.no5;

public class LongestPalindromicSubstring_DP {
    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int len = s.length(), begin = 0, maxLen = 1;
        if (len < 2) return s;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) dp[i][i] = true; // 单个字符，总是回文
        for (int j = 1; j < len; j++) { // 先遍历列
            for (int i = 0; i < j; i++) { // 再遍历行
                if (arr[i] == arr[j]) {
                    if (j - i < 3) dp[i][j] = true;
                    else dp[i][j] = dp[i + 1][j - 1]; // 左下角/西南角 -- 依赖于前一列，故先遍历列
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    begin = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
