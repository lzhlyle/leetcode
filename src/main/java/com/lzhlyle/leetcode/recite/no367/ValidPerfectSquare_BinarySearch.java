package com.lzhlyle.leetcode.recite.no367;

public class ValidPerfectSquare_BinarySearch {
    public boolean isPerfectSquare(int num) {
        long begin = 0, end = num;
        while (begin <= end) {
            long mid = begin + ((end - begin) >> 1);
            if (mid * mid == num) return true;
            else if (mid * mid > num) end = mid - 1;
            else begin = mid + 1;
        }
        return false;
    }
}
