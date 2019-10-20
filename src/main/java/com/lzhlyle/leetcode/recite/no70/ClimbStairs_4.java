package com.lzhlyle.leetcode.recite.no70;

public class ClimbStairs_4 {
//    public static void main(String[] args) {
//        int res = new ClimbStairs_4().climbStairs(10);
//        System.out.println(res);
//    }

    // 正遍历，两数
    // 1, 2, 3, 5, 8, 13...

    public int climbStairs(int n) {
        int a = 1, b = 1;
        while (n-- > 0) { // access n times
            b = b + a; // move b
            a = b - a; // move a
        }
        return a;
    }
}
