package com.lzhlyle.leetcode.self.no11;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        // 暴力解
        if (height == null || height.length < 2) return 0;

        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                max = Math.max(max, area);
            }
        }
        return max;
    }
}
