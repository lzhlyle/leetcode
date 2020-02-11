package com.lzhlyle.leetcode.self.no69;

public class Sqrtx {
    public int mySqrt(int x) {
        long begin = 0, end = (x >> 1) + 1;
        while (begin < end) {
            long mid = begin + ((end - begin + 1) >> 1);
            if (mid * mid > x) end = mid - 1;
            else begin = mid;
        }
        return (int) begin;
    }
}
