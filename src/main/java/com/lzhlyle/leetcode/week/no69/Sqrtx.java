package com.lzhlyle.leetcode.week.no69;

public class Sqrtx {
    public int mySqrt(int x) {
        long left = 0, right = (x >> 1) + 1; // +1 解决左边界
        while (left < right) {
            long mid = left + ((right - left) >> 1) + 1; // 取右边界，否则 left = mid; 后可能死循环
            if (mid * mid > x) right = mid - 1; // 大了肯定不行，故 right = mid - 1;
            else left = mid;
        }
        return (int) left;
    }
}
