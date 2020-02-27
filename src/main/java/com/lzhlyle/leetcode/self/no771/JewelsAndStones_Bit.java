package com.lzhlyle.leetcode.self.no771;

public class JewelsAndStones_Bit {
    public int numJewelsInStones(String J, String S) {
        long jewels = 0b0L;
        for (char c : J.toCharArray()) jewels |= 1L << (c - 'A');

        int count = 0;
        for (char c : S.toCharArray()) count += (jewels >> (c - 'A')) & 1;
        return count;
    }
}
