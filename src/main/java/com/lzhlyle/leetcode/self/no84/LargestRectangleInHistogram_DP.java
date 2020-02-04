package com.lzhlyle.leetcode.self.no84;

public class LargestRectangleInHistogram_DP {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) return 0;

        int[] lefts = new int[len];
        lefts[0] = -1;
        for (int i = 1; i < len; i++) {
            int l = i - 1;
            while (l >= 0 && heights[l] >= heights[i]) l = lefts[l];
            lefts[i] = l;
        }

        int[] rights = new int[len];
        rights[len - 1] = len;
        for (int i = len - 2; i >= 0; i--) {
            int r = i + 1;
            while (r < len && heights[r] >= heights[i]) r = rights[r];
            rights[i] = r;
        }

        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, heights[i] * (rights[i] - lefts[i] - 1));
        }
        return max;
    }
}
