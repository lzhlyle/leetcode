package com.lzhlyle.leetcode.tomorrow.no986;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections_MergeSort {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int l = Math.max(A[i][0], B[j][0]);
            int r = Math.min(A[i][1], B[j][1]);
            if (l <= r) list.add(new int[]{l, r});

            if (r == A[i][1]) i++;
            else j++;
        }
        return list.toArray(new int[list.size()][2]);
    }
}
