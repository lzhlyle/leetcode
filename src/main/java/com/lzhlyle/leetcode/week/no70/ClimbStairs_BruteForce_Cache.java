package com.lzhlyle.leetcode.week.no70;

public class ClimbStairs_BruteForce_Cache {
    private int[] memo;

    public int climbStairs(int n) {
        memo = new int[n + 1];
        return _fib(n);
    }

    private int _fib(int n) {
        if (n < 0) return 0;
        if (n < 3) return n;
        if (memo[n] > 0) return memo[n];
        int res = _fib(n - 2) + _fib(n - 1);
        memo[n] = res;
        return res;
    }
}
