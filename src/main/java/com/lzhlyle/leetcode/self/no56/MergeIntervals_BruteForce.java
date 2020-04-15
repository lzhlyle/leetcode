package com.lzhlyle.leetcode.self.no56;

public class MergeIntervals_BruteForce {
    // brute force
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len < 2) return intervals;

        int cnt = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (intervals[i][0] <= intervals[j][1] && intervals[i][1] >= intervals[j][0]) {
                    intervals[j][0] = Math.min(intervals[j][0], intervals[i][0]);
                    intervals[j][1] = Math.max(intervals[j][1], intervals[i][1]);
                    intervals[i] = null;
                    cnt++;
                    break;
                }
            }
        }

        int[][] res = new int[len - cnt][2];
        int ri = 0;
        for (int[] pair : intervals) {
            if (pair != null) res[ri++] = pair;
        }
        return res;
    }
}
