package com.lzhlyle.leetcode.tomorrow.no973;

import java.util.Arrays;

public class KClosestPointsToOrigin_LC_Sort {
    public int[][] kClosest(int[][] points, int K) {
        int n = points.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = dis(points[i]);

        Arrays.sort(arr);
        int distK = arr[K - 1];

        int[][] res = new int[K][2];
        int i = 0;
        for (int[] p : points)
            if (dis(p) <= distK)
                res[i++] = p;
        return res;
    }

    private int dis(int[] p) {
        int x = p[0], y = p[1];
        return x * x + y * y;
    }
}
