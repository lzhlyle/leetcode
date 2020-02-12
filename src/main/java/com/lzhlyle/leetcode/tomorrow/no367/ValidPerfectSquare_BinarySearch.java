package com.lzhlyle.leetcode.tomorrow.no367;

public class ValidPerfectSquare_BinarySearch {
    public boolean isPerfectSquare(int num) {
        long left = 0, right = (num >> 1) + 1;
        while (left < right) {
            long mid = left + ((right - left) >> 1) + 1; // 取右中位数
            if (mid * mid == num) return true;
            else if (mid * mid > num) right = mid - 1;
            else left = mid;
        }
        return false;
    }
}
