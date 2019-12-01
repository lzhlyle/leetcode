package com.lzhlyle.leetcode.recite.no56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals_3 {
    public int[][] merge(int[][] intervals) {
        // sort start&end
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        // loop through
        List<int[]> res = new ArrayList<>();
        // j is start of interval.
        for (int i = 0, j = 0; i < n; i++) {
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                res.add(new int[]{starts[j], ends[i]});
                j = i + 1;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {1, 5}, {10, 80}, {0, 6}, {2, 3}};
        // 0, 1, 1, 2, 10
        // 3, 4, 5, 6, 80
        int[][] res = new MergeIntervals_3().merge(intervals);
        System.out.println(Arrays.deepToString(res));
    }
}
