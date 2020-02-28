package com.lzhlyle.leetcode.recite.no279;

public class PerfectSquares_LC_Math {
    public int numSquares(int n) {
        while (n % 4 == 0) n /= 4; // 模掉最小的完全平方数
        if (n % 8 == 7) return 4; // 差一点达到完全平方数的，除了3

        for (int i = 1; i * i <= n; i++) {
            if (i * i == n) return 1; // 能够被完全平方掉
        }

        for (int i = 1; i * i <= n; i++) { // 差一步被完全平方掉
            int b = (int) Math.sqrt(n - i * i);
            if (b * b + i * i == n) return 2;
        }

        return 3;
    }

    public static void main(String[] args) {
        int res = new PerfectSquares_LC_Math().numSquares(15);
        System.out.println(res);
    }
}
