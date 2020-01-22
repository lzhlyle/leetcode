package com.lzhlyle.leetcode.week.no91;

public class DecodeWays_DP_Adv {
    public int numDecodings(String s) {
        if (s == null || s.length() < 1 || s.startsWith("0")) return 0;
        char[] arr = s.toCharArray();
        int dp0 = 0, dp1 = 1;
        for (int i = 1; i < arr.length; i++) {
            int tmp0 = 0, tmp1 = 0;
            if (arr[i - 1] > '0' && (arr[i - 1] - '0') * 10 + (arr[i] - '0') < 27) tmp0 = dp1;
            if (arr[i] > '0') tmp1 = dp0 + dp1;
            dp0 = tmp0;
            dp1 = tmp1;
        }
        return dp0 + dp1;
    }
}
