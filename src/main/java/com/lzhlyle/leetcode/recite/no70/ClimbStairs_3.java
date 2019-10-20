package com.lzhlyle.leetcode.recite.no70;

public class ClimbStairs_3 {
    // 正遍历，三数

    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n <= 2) return n;

        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
