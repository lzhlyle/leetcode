package com.lzhlyle.leetcode.tomorrow.no11;

public class ContainerWithMostWater_3 {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;

        int left = 0, right = height.length - 1, max = 0;
        while (left < right) {
            if (height[left] < height[right]) max = Math.max(max, (right - left) * (height[left++]));
            else max = Math.max(max, (right - left) * (height[right--]));
        }
        return max;
    }
}
