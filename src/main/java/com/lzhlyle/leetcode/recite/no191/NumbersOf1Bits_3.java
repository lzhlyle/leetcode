package com.lzhlyle.leetcode.recite.no191;

public class NumbersOf1Bits_3 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // 32次
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }
}
