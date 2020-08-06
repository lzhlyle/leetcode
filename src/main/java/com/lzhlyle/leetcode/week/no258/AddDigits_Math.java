package com.lzhlyle.leetcode.week.no258;

public class AddDigits_Math {
    public int addDigits(int num) {
        if (num == 0) return 0;
        if (num % 9 == 0) return 9;
        return num % 9;
    }
}
