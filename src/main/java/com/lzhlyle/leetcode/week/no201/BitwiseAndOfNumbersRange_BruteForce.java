package com.lzhlyle.leetcode.week.no201;

public class BitwiseAndOfNumbersRange_BruteForce {
    public int rangeBitwiseAnd(int m, int n) {
        int res = m;
        for (int i = m + 1; i >= m && i <= n; i++) {
            res &= i;
            if (res == 0) return 0;
        }
        return res;
    }
}
