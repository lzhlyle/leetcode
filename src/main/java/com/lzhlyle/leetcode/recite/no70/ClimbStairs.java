package com.lzhlyle.leetcode.recite.no70;

public class ClimbStairs {
//    public static void main(String[] args) {
//        int count =new ClimbStairs().climbStairs(10);
//        System.out.println(count);
//    }

    // fib，倒推，递归，缓存

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
        if (n <= 0) return 0;

        // get from cache
        if (fibCache[n] != 0) return fibCache[n];

        // recursive call
        int res = fib(n - 1) + fib(n - 2);
        if (res < 0) {
            // out of bound
            throw new RuntimeException("Too large number.");
        }

        // set into cache
        fibCache[n] = res;
        return res;
    }
}
