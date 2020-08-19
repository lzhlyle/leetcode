package com.lzhlyle.leetcode.tomorrow.no967;

import java.util.Arrays;

public class NumbersWithSameConsecutiveDifferences_BFS_Recursion {
    public int[] numsSameConsecDiff(int n, int k) {
        return bfs(1, n, k, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 10);
    }

    private int[] bfs(int i, int n, int k, int[] curr, int len) {
        if (i == n) return Arrays.copyOfRange(curr, 0, len);
        int[] res = new int[len * 2];
        int ri = 0;
        for (int j = 0; j < len; j++) {
            int v = curr[j];
            if (v > 0) {
                int d = v % 10;
                if (d + k <= 9) res[ri++] = v * 10 + d + k;
                if (k > 0 && d - k >= 0) res[ri++] = v * 10 + d - k;
            }
        }
        return bfs(i + 1, n, k, res, ri);
    }
}
