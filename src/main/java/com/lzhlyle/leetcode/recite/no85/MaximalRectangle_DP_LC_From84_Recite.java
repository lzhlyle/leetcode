package com.lzhlyle.leetcode.recite.no85;

public class MaximalRectangle_DP_LC_From84_Recite {
    // dp
    // from no84
    // O(mn)
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int n = matrix[0].length, max = 0;
        int[] heights = new int[n];
        for (char[] row : matrix) {
            for (int j = 0; j < n; j++) {
                if (row[j] == '1') heights[j] += 1;
                else heights[j] = 0;
            }
            max = Math.max(max, calcArea(heights));
        }
        return max;
    }

    private int calcArea(int[] heights) {
        int len = heights.length, max = 0;
        int[] dpl = new int[len];
        dpl[0] = -1;
        for (int i = 1; i < len; i++) {
            int l = i - 1;
            while (l >= 0 && heights[l] >= heights[i]) l = dpl[l];
            dpl[i] = l;
        }

        int[] dpr = new int[len];
        dpr[len - 1] = len;
        for (int i = len - 2; i >= 0; i--) {
            int r = i + 1;
            while (r < len && heights[r] >= heights[i]) r = dpr[r];
            dpr[i] = r;
        }

        for (int i = 0; i < len; i++) {
            max = Math.max(max, heights[i] * (dpr[i] - dpl[i] - 1));
        }
        return max;
    }
}
