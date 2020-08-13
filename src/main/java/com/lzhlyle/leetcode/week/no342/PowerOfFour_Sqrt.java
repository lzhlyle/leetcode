package com.lzhlyle.leetcode.week.no342;

public class PowerOfFour_Sqrt {
    public boolean isPowerOfFour(int num) {
        if (num == 0) return false;
        int sq = (int) Math.sqrt(num);
        if ((sq & (sq - 1)) != 0) return false;
        return sq * sq == num;
    }
}
