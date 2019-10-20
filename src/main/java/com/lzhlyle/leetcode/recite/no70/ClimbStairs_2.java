package com.lzhlyle.leetcode.recite.no70;

public class ClimbStairs_2 {
    // 正遍历，缓存

    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n <= 2) return n;

        int[] memo = new int[n + 1];
        memo[1] = 1;
        memo[2] = 2;
        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }
}
