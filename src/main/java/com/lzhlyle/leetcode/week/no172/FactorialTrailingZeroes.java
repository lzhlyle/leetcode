package com.lzhlyle.leetcode.week.no172;

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int cnt = 0;
        while (n > 0)
            cnt += n = n / 5;
        return cnt;
    }
}
