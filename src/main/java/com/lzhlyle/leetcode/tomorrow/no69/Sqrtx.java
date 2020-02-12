package com.lzhlyle.leetcode.tomorrow.no69;

public class Sqrtx {
    public int mySqrt(int x) {
        long left = 0, right = (x >> 1) + 1;
        while (left < right) {
            long mid = left + ((right - left) >> 1) + 1; // 取右中位数
            if (mid * mid > x) right = mid - 1;
            else left = mid;
        }
        return (int) left;
    }
}
