package com.lzhlyle.leetcode.self.no191;

public class NumbersOf1Bits_2 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // 32次
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += (n >> i & 1) == 1 ? 1 : 0;
        }
        return count;
    }
}
