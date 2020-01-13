package com.lzhlyle.leetcode.tomorrow.no70;

public class ClimbStairsNew_1 {
    // 递归，记忆化搜索
    public int climbStairs(int n) {
        return _fib(n, new int[n + 1]);
    }

    private int _fib(int n, int[] cache) {
        if (cache[n] != 0) return cache[n];
        if (n <= 2) return cache[n] = n;
        return cache[n] = _fib(n - 1, cache) + _fib(n - 2, cache);
    }
}
