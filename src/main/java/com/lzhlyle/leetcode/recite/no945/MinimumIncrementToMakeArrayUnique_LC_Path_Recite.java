package com.lzhlyle.leetcode.recite.no945;

import java.util.Arrays;

public class MinimumIncrementToMakeArrayUnique_LC_Path_Recite {
    // O(n)
    private int[] arr = new int[80000];

    public int minIncrementForUnique(int[] A) {
        Arrays.fill(arr, -1);
        int cnt = 0;
        for (int num : A) cnt += find(num) - num;
        return cnt;
    }

    private int find(int num) {
        int curr = arr[num];
        if (curr == -1) return arr[num] = num;
        curr = find(curr + 1);
        return arr[num] = curr;
    }
}
