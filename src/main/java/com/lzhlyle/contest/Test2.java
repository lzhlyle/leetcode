package com.lzhlyle.contest;

public class Test2 {
    public int climbStairs(int n) {
        // base condition
        if (n <= 0) return 0;
        if (n <= 2) return n;

        // 1, 2, 3, 5, 8, 13, 21, ...
        int a = 1, b = 2;
        for (int i = 2; i < n; i++) {
            b = b + a;
            a = b - a;
        }
        return b;
    }

    public static void main(String[] args) {
        Object res = new Test2().climbStairs(7);
        System.out.println(res);
    }
}
