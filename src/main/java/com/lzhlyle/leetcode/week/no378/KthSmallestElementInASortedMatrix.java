package com.lzhlyle.leetcode.week.no378;

public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        if (n == 0) return 0;

        int l = matrix[0][0], r = matrix[n - 1][n - 1];
        while (l < r) {
            int mid = l + (r - l) / 2;
            int cnt = lessOrEqualsCnt(matrix, mid);
            if (cnt < k) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    private int lessOrEqualsCnt(int[][] matrix, int mid) {
        int n = matrix.length, cnt = 0;
        int i = 0, j = n - 1;
        while (i < n && j >= 0) {
            if (matrix[i][j] <= mid) {
                cnt += j + 1;
                i++;
            } else j--;
        }
        return cnt;
    }
}
