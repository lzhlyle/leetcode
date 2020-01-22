package com.lzhlyle.leetcode.week.no190;

public class ReverseBits_HighToLow {
    public int reverseBits(int n) {
        int res = 0b0, i = 0;
        while (i++ < 32) res |= ((n >> i) & 1) << (31 - i);
        return res;
    }
}
