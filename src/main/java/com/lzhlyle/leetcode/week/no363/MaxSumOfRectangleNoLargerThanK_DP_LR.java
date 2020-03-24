package com.lzhlyle.leetcode.week.no363;

public class MaxSumOfRectangleNoLargerThanK_DP_LR {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length, res = Integer.MIN_VALUE;
        for (int l = 0; l < n; l++) {
            int[] rowSum = new int[m];
            for (int r = l; r < n; r++) {
                for (int i = 0; i < m; i++) {
                    rowSum[i] += matrix[i][r];
                }
                res = Math.max(res, dpmax(rowSum, k));
                if (res == k) return k;
            }
        }
        return res;
    }

    private int dpmax(int[] arr, int k) {
        int dp = arr[0], max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (dp > 0) dp += arr[i];
            else dp = arr[i];
            if (dp > max) max = dp;
            if (max == k) return k;
        }
        if (max < k) return max;

        int res = Integer.MIN_VALUE;
        for (int l = 0; l < arr.length; l++) {
            int sum = 0;
            for (int r = l; r < arr.length; r++) {
                sum += arr[r];
                if (sum > res && sum <= k) res = sum;
                if (res == k) return k;
            }
        }
        return res;
    }
}
