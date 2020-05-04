package com.lzhlyle.leetcode.self.no476;

public class NumberComplement_Adv {
    // 全1异或
    public int findComplement(int num) {
        int i = 0;
        while ((num >> i) != 0) i++;
        return ((1 << i) - 1) ^ num;
    }
}
