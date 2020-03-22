package com.lzhlyle.leetcode.self.no945;

import java.util.Arrays;

public class MinimumIncrementToMakeArrayUnique_LC_Sort {
    // O(nlog(n))
    public int minIncrementForUnique(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length, cnt = 0;
        for (int i = 1; i < len; i++) {
            while (arr[i] <= arr[i - 1]) {
                arr[i]++;
                cnt++;
            }
        }
        return cnt;
    }
}
