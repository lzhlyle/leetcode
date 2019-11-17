package com.lzhlyle.leetcode.recite.no91;

public class DecodeWays {
    public int numDecodings(String s) {
        // base condition
        if (s == null || s.length() < 1) return 0;
        if (s.startsWith("0")) return 0;

        char[] arr = s.toCharArray();
        int[][] f = new int[arr.length][2];
        f[0][0] = 0; // 不独立解析 false
        f[0][1] = 1; // 独立解析 true
        for (int i = 1; i < arr.length; i++) {
            // 独立解析
            if (arr[i] > '0') f[i][1] = f[i - 1][0] + f[i - 1][1];
            // 不独立解析
            if (arr[i - 1] > '0' && (arr[i - 1] - '0') * 10 + (arr[i] - '0') < 27) f[i][0] = f[i - 1][1];
        }
        return f[arr.length - 1][0] + f[arr.length - 1][1];
    }

    public static void main(String[] args) {
        String str = "1271031";
        int res = new DecodeWays().numDecodings(str);
        System.out.println(res);
    }
}
