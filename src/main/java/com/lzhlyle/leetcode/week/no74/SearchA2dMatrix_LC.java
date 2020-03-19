package com.lzhlyle.leetcode.week.no74;

public class SearchA2dMatrix_LC {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length, l = 0, r = m * n - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (matrix[mid / n][mid % n] < target) l = mid + 1;
            else r = mid;
        }
        return matrix[l / n][l % n] == target;
    }
}
