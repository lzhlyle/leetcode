package com.lzhlyle.leetcode.self.no11;

public class ContainerWithMostWater_2 {
    public int maxArea(int[] height) {
        // 收敛夹逼
        if (height == null || height.length < 2) return 0;
        int max = 0;
        int left = 0;
        int right = height.length - 1;
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
