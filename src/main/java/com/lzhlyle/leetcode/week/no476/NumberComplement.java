package com.lzhlyle.leetcode.week.no476;

public class NumberComplement {
    // 逐位取反
    public int findComplement(int num) {
        int res = 0b0, i = 0;
        while (num != 0) {
            res |= (((num & 1) == 0) ? 1 : 0) << i++;
            num >>= 1;
        }
        return res;
    }
}
