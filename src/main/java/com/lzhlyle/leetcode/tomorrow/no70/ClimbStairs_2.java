package com.lzhlyle.leetcode.tomorrow.no70;

public class ClimbStairs_2 {

    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n <= 2) return n;

        // 正遍历，缓存
        int[] cache = new int[n + 1];
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 2;

        for (int i = 3; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }
}
