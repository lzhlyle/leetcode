package com.lzhlyle.leetcode.week.no70;

public class ClimbStairs_DP_Adv {
    public int climbStairs(int n) {
        if (n < 0) return 0;
        if (n < 3) return n;
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            b = b + a;
            a = b - a;
        }
        return b;
    }
}
