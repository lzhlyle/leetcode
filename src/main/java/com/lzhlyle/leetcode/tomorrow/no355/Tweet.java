package com.lzhlyle.leetcode.tomorrow.no355;

public class Tweet {
    private static int CNT = 0;
    int id, sort;

    public Tweet(int id) {
        this.id = id;
        this.sort = ++CNT;
    }
}
