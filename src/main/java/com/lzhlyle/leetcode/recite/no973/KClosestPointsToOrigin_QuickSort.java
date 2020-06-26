package com.lzhlyle.leetcode.recite.no973;

import java.util.Arrays;

public class KClosestPointsToOrigin_QuickSort {
    public int[][] kClosest(int[][] points, int K) {
        quickSort(points, 0, points.length - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    private void quickSort(int[][] points, int l, int r, int k) {
        if (l >= r) return;
        int p = partition(points, l, r);
        if (p == k) return;
        if (p < k) quickSort(points, p + 1, r, k);
        else quickSort(points, l, p - 1, k);
    }

    private int partition(int[][] points, int l, int r) {
        int p = r, c = l;
        for (int i = l; i < r; i++) {
            if (dis(points[i]) < dis(points[r])) {
                swap(points, i, c++);
            }
        }
        swap(points, p, c);
        return c;
    }

    private void swap(int[][] points, int i, int j) {
        if (i == j) return;
        int[] swap = points[i];
        points[i] = points[j];
        points[j] = swap;
    }

    private long dis(int[] point) {
        int x = point[0], y = point[1];
        return x * x + y * y;
    }
}
