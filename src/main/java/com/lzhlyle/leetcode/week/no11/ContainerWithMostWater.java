package com.lzhlyle.leetcode.week.no11;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;

        int left = 0, right = height.length - 1, max = 0;
        while (left < right) {
            int width = right - left;
            if (height[left] < height[right]) max = Math.max(max, width * height[left++]);
            else max = Math.max(max, width * height[right--]);
        }
        return max;
    }
}
