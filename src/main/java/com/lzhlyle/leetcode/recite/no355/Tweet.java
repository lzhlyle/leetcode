package com.lzhlyle.leetcode.recite.no355;

public class Tweet {
    static int _CNT = 0;
    int id, sort;

    public Tweet(int id) {
        this.id = id;
        this.sort = ++_CNT;
    }
}
