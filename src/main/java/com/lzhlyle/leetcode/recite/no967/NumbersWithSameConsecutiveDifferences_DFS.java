package com.lzhlyle.leetcode.recite.no967;

import java.util.Arrays;

public class NumbersWithSameConsecutiveDifferences_DFS {
    public int[] numsSameConsecDiff(int n, int k) {
        return dfs(1, n, k, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
    }

    private int[] dfs(int i, int n, int k, int[] curr) {
        if (i == n) return curr;
        int[] next = new int[curr.length * 10];
        int j = 0;
        for (int v : curr) {
            if (v > 0) {
                int d = v % 10;
                if (d + k <= 9) next[j++] = v * 10 + d + k;
                if (k > 0 && d - k >= 0) next[j++] = v * 10 + d - k;
            }
        }
        return dfs(i + 1, n, k, Arrays.copyOfRange(next, 0, j));
    }
}
