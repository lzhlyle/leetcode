package com.lzhlyle.leetcode.week.no441;

public class ArrangingCoins {
    public int arrangeCoins(int n) {
        long l = 0, r = n;
        while (l < r) {
            long mid = l + (r - l + 1) / 2;
            if (sum(mid) > n) r = mid - 1;
            else l = mid;
        }
        return (int) l;
    }

    private long sum(long i) {
        return i * (1 + i) / 2;
    }
}
