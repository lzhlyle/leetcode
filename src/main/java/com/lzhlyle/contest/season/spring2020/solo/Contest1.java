package com.lzhlyle.contest.season.spring2020.solo;

public class Contest1 {
    public int minCount(int[] coins) {
        int cnt = 0;
        for (int c : coins) {
            cnt += c / 2 + (c % 2);
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println("begin");
        Contest1 contest = new Contest1();
        {

        }
    }
}
