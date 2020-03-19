package com.lzhlyle.leetcode.week.no74;

public class SearchA2dMatrix_LC_Table {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int ri = 0, ci = matrix[0].length - 1;
        while (ri < matrix.length && ci >= 0) {
            if (matrix[ri][ci] < target) ri++;
            else if (matrix[ri][ci] > target) ci--;
            else return true;
        }
        return false;
    }
}
