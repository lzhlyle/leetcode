package com.lzhlyle.contest.biweekly.biweekly31;

public class Contest1 {
    public int countOdds(int low, int high) {
        int cnt = high - low;
        int res = (cnt & 1) == 0 ? (cnt / 2) : (cnt + 1) / 2;
        if (((low & 1) == 1) && ((high & 1) == 1)) res += 1;
        return res;
    }

    public static void main(String[] args) {
        Contest1 contest = new Contest1();
        {

        }
    }
}
