package com.lzhlyle.contest.date20191215;

public class DecodeWays_2 {
    public int numDecodings(String s) {
        // base condition
        if (s == null || s.startsWith("0")) return 0;
        int n = s.length();
        if (n <= 1) return n;

//        int[][] dp = new int[n][2];
//        dp[0][0] = 0; // 联合解析
//        dp[0][1] = 1; // 独立解析

        int dpi0 = 0, dpi1 = 1;

        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            int prevNum = chars[i - 1] - '0';
            int currNum = chars[i] - '0';
            int tmpi0 = ((prevNum > 0) && ((prevNum * 10 + currNum) < 27)) ? dpi1 : 0; // 联合解析
            int tmpi1 = (currNum > 0) ? (dpi0 + dpi1) : 0; // 独立解析

            dpi0 = tmpi0;
            dpi1 = tmpi1;
        }

        return dpi0 + dpi1;
    }

    public static void main(String[] args) {
        String s = "226";
        int res = new DecodeWays_2().numDecodings(s);
        System.out.println(res);
    }
}
