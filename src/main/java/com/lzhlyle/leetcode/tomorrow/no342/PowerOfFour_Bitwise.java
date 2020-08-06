package com.lzhlyle.leetcode.tomorrow.no342;

public class PowerOfFour_Bitwise {
    public boolean isPowerOfFour(int num) {
        if (num == 0) return false;
        if ((num & (num - 1)) != 0) return false;
        int cnt = 0;
        while ((num >>> cnt) != 1) cnt++;
        return (cnt & 1) == 0;
    }
}
