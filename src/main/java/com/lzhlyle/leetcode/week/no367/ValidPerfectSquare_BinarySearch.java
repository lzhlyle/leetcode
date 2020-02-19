package com.lzhlyle.leetcode.week.no367;

public class ValidPerfectSquare_BinarySearch {
    public boolean isPerfectSquare(int num) {
        long left = 0, right = (num >> 1) + 1;
        while (left < right) {
            long mid = left + ((right - left) >> 1) + 1, multi = mid * mid;
            if (multi == num) return true;
            else if (multi > num) right = mid - 1;
            else left = mid;
        }
        return false;
    }
}
