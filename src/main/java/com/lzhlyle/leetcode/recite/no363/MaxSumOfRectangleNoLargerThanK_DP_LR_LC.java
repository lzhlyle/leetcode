package com.lzhlyle.leetcode.recite.no363;

public class MaxSumOfRectangleNoLargerThanK_DP_LR_LC {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length;
        int res = Integer.MIN_VALUE;

        for (int l = 0; l < cols; l++) {
            int[] rowSum = new int[rows];
            for (int r = l; r < cols; r++) {
                int sum = 0;
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < rows; i++) {
                    rowSum[i] += matrix[i][r]; // 按每一行累计到 rowSum
                    // 滚动记录当前最大值
                    if (sum > 0) sum += rowSum[i];
                    else sum = rowSum[i];
                    max = Math.max(max, sum);
                }

                // 超过 k 才值得深入遍历
                if (max > k) {
                    max = Integer.MIN_VALUE;
                    for (int rowStart = 0; rowStart < rows; rowStart++) { // 枚举左
                        sum = 0;
                        for (int row = rowStart; row < rows; row++) { // 枚举右
                            sum += rowSum[row];
                            if (sum <= k && sum > max) max = sum;
                        }
                    }
                }
                res = Math.max(res, max);
                if (res == k) return res;
            }
        }
        return res;
    }
}
