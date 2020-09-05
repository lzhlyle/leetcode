package com.lzhlyle.leetcode.week.no470;

public class ImplementRand10UsingRand7_UseRand3Rand21 {
    public int rand10() {
        int res = 21;
        while (res > 20)
            res = rand21();
        return res % 10 + 1;
    }

    private int rand21() {
        return (rand3() - 1) * 7 + rand7();
    }

    private int rand3() {
        int res = 7;
        while (res > 6)
            res = rand7();
        return res % 3 + 1;
    }

    private int rand7() {
        return -1;
    }
}
