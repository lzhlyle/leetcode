package com.lzhlyle.leetcode.recite.no461;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int d = x ^ y, cnt = 0;
        while (d != 0) {
            d &= d - 1;
            cnt++;
        }
        return cnt;
    }
}
