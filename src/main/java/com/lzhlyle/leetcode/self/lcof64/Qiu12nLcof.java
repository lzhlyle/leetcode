package com.lzhlyle.leetcode.self.lcof64;

public class Qiu12nLcof {
    public int sumNums(int n) {
        boolean b = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
