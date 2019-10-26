package com.lzhlyle.leetcode.tomorrow.no11;

public class ContainerWithMostWater_2 {
    public int maxArea(int[] height) {
        // 收敛夹逼
        if (height == null || height.length < 2) return 0;
        if (height.length == 2) return Math.min(height[0], height[1]);

        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                max = Math.max(max, height[left] * (right - left));
                left++;
            } else {
                max = Math.max(max, height[right] * (right - left));
                right--;
            }
        }

        return max;
    }
}
