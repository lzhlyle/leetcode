package com.lzhlyle.leetcode.week.no338;

public class CountingBits_BruteForce {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int tmp = i;
            while (tmp != 0) {
                tmp &= tmp - 1;
                res[i]++;
            }
        }
        return res;
    }
}
