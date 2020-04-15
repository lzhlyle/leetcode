package com.lzhlyle.leetcode.recite.no56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals_SortStartEnd {
    // sort start and end
    // 2ms
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int[] starts = new int[n], ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        // loop through
        List<int[]> list = new ArrayList<>();
        // j is start of interval.
        for (int i = 0, j = 0; i < n; i++) {
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                list.add(new int[]{starts[j], ends[i]});
                j = i + 1;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
