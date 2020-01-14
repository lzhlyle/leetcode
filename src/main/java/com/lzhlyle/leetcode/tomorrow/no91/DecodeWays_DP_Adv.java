package com.lzhlyle.leetcode.tomorrow.no91;

public class DecodeWays_DP_Adv {
    public int numDecodings(String s) {
        if (s == null || s.length() < 1) return 0;
        if (s.startsWith("0")) return 0;

        char[] arr = s.toCharArray();
        int length = arr.length;
        int dp0 = 0; // 不独立解析
        int dp1 = 1; // 独立解析

        for (int i = 1; i < length; i++) {
            int t0 = 0, t1 = 0;
            if (arr[i - 1] > '0' && (arr[i - 1] - '0') * 10 + (arr[i] - '0') < 27) t0 = dp1;
            if (arr[i] > '0') t1 = dp0 + dp1;
            dp0 = t0;
            dp1 = t1;
        }

        return dp0 + dp1;
    }
}
