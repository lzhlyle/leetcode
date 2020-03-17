package com.lzhlyle.leetcode.tomorrow.no363;

public class MaxSumOfRectangleNoLargerThanK_DP_LR {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length, res = Integer.MIN_VALUE;
        for (int l = 0; l < cols; l++) {
            int[] rowSum = new int[rows];
            for (int r = l; r < cols; r++) {
                for (int i = 0; i < rows; i++) {
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
