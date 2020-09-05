package com.lzhlyle.leetcode.week.no470;

public class ImplementRand10UsingRand7 {
    public int rand10() {
        int res = 0;
        do {
            res = (rand7() - 1) * 7 + rand7();
        } while (res > 40);
        return res % 10 + 1;
    }

    private int rand7() {
        return -1;
    }
}
