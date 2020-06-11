package com.lzhlyle.leetcode.tomorrow.no461;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y, cnt = 0;
        while (xor != 0) {
            xor &= xor - 1;
            cnt++;
        }
        return cnt;
    }
}
