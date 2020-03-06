package com.lzhlyle.leetcode.week.no771;

public class JewelsAndStones_Bit {
    public int numJewelsInStones(String J, String S) {
        long j = 0b0L;
        for (char c : J.toCharArray()) j |= 1L << (c - 'A');

        int cnt = 0;
        for (char c : S.toCharArray()) cnt += (j >> (c - 'A')) & 1;
        return cnt;
    }
}
