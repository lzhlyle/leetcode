package com.lzhlyle.leetcode.self.no435;

import java.util.Arrays;

public class NonOverlappingIntervals_Greedy {
    public int eraseOverlapIntervals(int[][] arr) {
        if (arr.length == 0) return 0;
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int cnt = 0, r = arr[0][1];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] >= r) r = arr[i][1]; // 无重叠
            else { // 有重叠
                cnt++;
                r = Math.min(r, arr[i][1]);
            }
        }
        return cnt;
    }
}
