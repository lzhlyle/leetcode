package com.lzhlyle.leetcode.tomorrow.no42;

public class TrappingRainWater_TwoPoints {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1, hl = 0, hr = 0, sum = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] > hl) hl = height[l++];
                else sum += hl - height[l++];
            } else {
                if (height[r] > hr) hr = height[r--];
                else sum += hr - height[r--];
            }
        }
        return sum;
    }
}
