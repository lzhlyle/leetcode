package com.lzhlyle.leetcode.tomorrow.no70;

public class ClimbStairs_4 {
    // 正遍历，两数
    // 1, 2, 3, 5, 8, 13...

    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n <= 2) return n;

        int a = 1;
        int b = 2;
        for (int i = 3; i < n; i++) {
            b = b + a;
            a = b - a;
        }
        return a + b;
    }
}
