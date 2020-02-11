package com.lzhlyle.leetcode.recite.no69;

public class Sqrtx {
    public int mySqrt(int x) {
        long begin = 0, end = (x >> 1) + 1; // +1照顾0
        while (begin < end) {
            long mid = begin + ((end - begin + 1) >> 1); // 右中位数
            if (mid * mid > x) end = mid - 1;
            else begin = mid;
        }
        return (int) begin;
    }
}
