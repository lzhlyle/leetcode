package com.lzhlyle.leetcode.self.no70;

public class ClimbStairs {
    // fib，倒退，递归，缓存
    private int[] fibCache;

    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n <= 2) return n;

        fibCache = new int[n + 1];
        fibCache[0] = 0;
        fibCache[1] = 1;
        fibCache[2] = 2;

        return fib(n);
    }

    private int fib(int n) {
        if (fibCache[n] > 0) return fibCache[n];
        int res = fib(n - 1) + fib(n - 2);
        fibCache[n] = res;
        return res;
    }
}
