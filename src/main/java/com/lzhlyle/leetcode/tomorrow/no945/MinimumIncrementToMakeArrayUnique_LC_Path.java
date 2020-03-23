package com.lzhlyle.leetcode.tomorrow.no945;

import java.util.Arrays;

public class MinimumIncrementToMakeArrayUnique_LC_Path {
    // O(n)
    private int[] pos = new int[80000]; // number, position

    public int minIncrementForUnique(int[] arr) {
        Arrays.fill(pos, -1);
        int cnt = 0;
        for (int num : arr) cnt += find(num) - num;
        return cnt;
    }

    private int find(int num) {
        int i = pos[num];
        if (i == -1) return pos[num] = num;
        return pos[num] = find(i + 1);
    }
}
