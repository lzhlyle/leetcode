package com.lzhlyle.leetcode.week.no42;

public class TrappingRainWater_DP {
    public int trap(int[] height) {
        int len = height.length, sum = 0;
        int[] dpl = new int[len], dpr = new int[len];
        for (int i = 1; i < len; i++) dpl[i] = Math.max(height[i - 1], dpl[i - 1]);
        for (int i = len - 2; i >= 0; i--) dpr[i] = Math.max(height[i + 1], dpr[i + 1]);
        for (int i = 0; i < len; i++) {
            int min = Math.min(dpl[i], dpr[i]);
            if (height[i] < min) sum += min - height[i];
        }
        return sum;
    }
}
