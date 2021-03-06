package com.lzhlyle.leetcode.recite.no74;

public class SearchA2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int[] head = new int[matrix.length];
        for (int r = 0; r < matrix.length; r++) head[r] = matrix[r][0];

        int hl = 0, hr = head.length - 1; // [l, r]
        while (hl < hr) {
            int mid = hl + ((hr - hl + 1) >>> 1);
            if (target < head[mid]) hr = mid - 1; // [l, mid - 1]
            else hl = mid; // [mid, r]
        }
        if (head[hl] == target) return true;

        int[] row = matrix[hl];
        int rl = 0, rr = row.length - 1; // [l, r]
        while (rl < rr) {
            int mid = rl + ((rr - rl) >>> 1);
            if (row[mid] < target) rl = mid + 1; // [mid + 1, r]
            else rr = mid;
        }
        return row[rl] == target;
    }
}
