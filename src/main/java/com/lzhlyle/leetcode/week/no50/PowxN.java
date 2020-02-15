package com.lzhlyle.leetcode.week.no50;

public class PowxN {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1 / x;
        double half = myPow(x, n >> 1);
        double rest = myPow(x, n & 1);
        return half * half * rest;
    }
}
