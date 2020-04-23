package com.lzhlyle.leetcode.self.no201;

public class BitwiseAndOfNumbersRange_LC_Adv2 {
    // 去掉低位 0: x & (x - 1)
    public int rangeBitwiseAnd(int m, int n) {
        while (n > m) n &= n - 1;
        return n;
    }
}
