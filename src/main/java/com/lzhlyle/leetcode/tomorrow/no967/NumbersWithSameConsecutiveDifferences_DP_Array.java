package com.lzhlyle.leetcode.tomorrow.no967;

import java.util.Arrays;

public class NumbersWithSameConsecutiveDifferences_DP_Array {
    public int[] numsSameConsecDiff(int n, int k) {
        int[] dp = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int len = dp.length;
        while (--n > 0) {
            int[] next = new int[len * 2];
            int i = 0;
            for (int j = 0; j < len; j++) {
                int v = dp[j];
                if (v > 0) {
                    int d = v % 10;
                    if (d + k <= 9) next[i++] = v * 10 + d + k;
                    if (k > 0 && d - k >= 0) next[i++] = v * 10 + d - k;
                }
            }
            dp = next;
            len = i;
        }
        return Arrays.copyOfRange(dp, 0, len);
    }
}
