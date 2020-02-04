package com.lzhlyle.leetcode.recite.no84;

public class LargestRectangleInHistogram_DP {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) return 0;

        int[] dpLeft = new int[len];
        dpLeft[0] = -1;
        for (int i = 1; i < len; i++) {
            int l = i - 1;
            while (l >= 0 && heights[l] >= heights[i]) l = dpLeft[l];
            dpLeft[i] = l;
        }

        int[] dpRight = new int[len];
        dpRight[len - 1] = len;
        for (int i = len - 2; i >= 0; i--) {
            int r = i + 1;
            while (r <= len - 1 && heights[r] >= heights[i]) r = dpRight[r];
            dpRight[i] = r;
        }

        int max = 0;
        for (int i = 0; i < len; i++) {
            int area = heights[i] * (dpRight[i] - dpLeft[i] - 1);
            max = Math.max(max, area);
        }
        return max;
    }
}
