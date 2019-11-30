package com.lzhlyle.leetcode.recite.no190;

public class ReverseBits_3 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0b0, i = 0;
        while (i++ < 32) res = (res << 1) | (n >>> (i - 1) & 1);
        return res;
    }
}
