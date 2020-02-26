package com.lzhlyle.leetcode.recite.no42;

public class TrappingRainWater_DP {
    public int trap(int[] height) {
        int len = height.length, sum = 0;
        int[] dpLeft = new int[len], dpRight = new int[len];
        for (int i = 1; i < len; i++) dpLeft[i] = Math.max(dpLeft[i - 1], height[i - 1]);
        for (int i = len - 2; i >= 0; i--) dpRight[i] = Math.max(dpRight[i + 1], height[i + 1]);
        for (int i = 0; i < len; i++) {
            int min = Math.min(dpLeft[i], dpRight[i]);
            if (min > height[i]) sum += min - height[i];
        }
        return sum;
    }
}
