package com.lzhlyle.leetcode.self.no279;

public class PerfectSquares_LC_Math {
    public int numSquares(int n) {
        while (n % 4 == 0) n /= 4;
        if (n % 8 == 7) return 4;

        for (int i = 0; i * i <= n; i++) {
            if (i * i == n) return 1;
        }

        for (int i = 0; i * i <= n; i++) {
            int b = (int) Math.sqrt(n - i * i);
            if (b * b + i * i == n) return 2;
        }

        return 3;
    }
}
