package com.lzhlyle.leetcode.week.no201;

public class BitwiseAndOfNumbersRange_LC_Adv1 {
    // 右移直到相等
    public int rangeBitwiseAnd(int m, int n) {
        int cnt = 0;
        while (n > m) {
            n >>>= 1;
            m >>>= 1;
            cnt++;
        }
        return m << cnt;
    }
}
