package com.lzhlyle.leetcode.recite.no91;

public class DecodeWays_2 {
    public int numDecodings(String s) {
        // base condition
        if (s == null || s.length() < 1) return 0;
        if (s.startsWith("0")) return 0;

        char[] arr = s.toCharArray();
        int f0 = 0; // 不独立解析
        int f1 = 1; // 独立解析
        for (int i = 1; i < arr.length; i++) {
            // 独立解析
            int a1 = (arr[i] > '0') ? f0 + f1 : 0;
            // 不独立解析
            int a0 = arr[i - 1] > '0' && (arr[i - 1] - '0') * 10 + (arr[i] - '0') < 27 ? f1 : 0;

            // 推变量
            f0 = a0;
            f1 = a1;
        }
        return f0 + f1;
    }

    public static void main(String[] args) {
        String str = "1271031";
        int res = new DecodeWays_2().numDecodings(str);
        System.out.println(res);
    }
}
